package com.slt.infobus.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBSlotTrackerDtl;
import com.slt.infobus.util.SlotBookings;
import com.slt.infobus.util.SlotDetails;

@Repository
@Transactional
public class SlotTrackerDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List findAll(){		
		return entityManager.createQuery("from IBSlotTrackerDtl").getResultList();
	}
	
	public List findAllByLocation(String locId){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date cal = new Date();//Calendar.getInstance();
		//List<SlotDetails> slotList = Collections.EMPTY_LIST;
		String date = dateFormat.format(cal);
		String qry = "from IBSlotTrackerDtl s where s.locationId="+locId+" and slotDate='"+date+"'";
		return entityManager.createQuery(qry).getResultList();
	}
	/**
	 * 
	 * @param locId
	 * @return
	 */
	
	public List<SlotDetails> findAllSlotsByGroup(String locId, String stTime, String enTime, Date slotDate){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//stDate = dateFormat.format(stDate);
		//enDate = dateFormat.format(enDate);
		//System.out.println(slotDate.toString()+","+enDate.toString());
		String qry = "SELECT SLOT_TIME, MIN(AVBL_SLOTS), MIN(BAL_SLOTS) FROM ib_slot_tracker_dtl i "
				+ " WHERE SLOT_DATE='"+slotDate.toString()+"'"
				+ " AND hour(SLOT_TIME) between hour('"+stTime+"') and hour('"+enTime+"') "
				+ " AND LOC_ID= "+locId
				+ " GROUP BY SLOT_TIME";
		List<SlotDetails> slotList = new ArrayList<SlotDetails>();		
		List<Object> dataList = entityManager.createNativeQuery(qry).getResultList();
		SlotDetails slot = null;		 
		if(dataList!=null && !dataList.isEmpty()){
			for(int i=0; i<dataList.size();i++) {
				slot = new SlotDetails();
				Object[] row = (Object[])dataList.get(i);
				slot.setSlotTime((java.sql.Time)row[0]);
				slot.setMinAvblSlots((Integer)row[1]);
				slot.setMinBalSlots((Integer)row[2]);
				slotList.add(slot);
			}
		}
		return slotList;
	}
	/**
	 * 
	 * @param slot
	 * @return
	 */
	public List<SlotBookings> getTotalBookedSlotsByGroup(String locId, String stTime, String enTime, Date stDate, Date enDate){
		String qry ="SELECT VIDEO_ID, LOC_ID, SLOT_DATE, SLOT_TIME, SUM(BKD_SLOTS), SUM(REPEATS_PER_HR) FROM ib_slot_tracker_dtl i 	"
				+ "	WHERE SLOT_DATE between '"+stDate+"' and '"+stDate+"'"
				+ " AND hour(SLOT_TIME) between hour('"+stTime+"') and hour('"+enTime+"') "
				+ " AND LOC_ID in ("+locId+")"
				+ "	GROUP BY VIDEO_ID,LOC_ID, SLOT_DATE,SLOT_TIME";
		
		List<SlotBookings> slotList = new ArrayList<SlotBookings>();		
		List<Object> dataList = entityManager.createNativeQuery(qry).getResultList();
		SlotBookings slot = null;		 
		if(dataList!=null && !dataList.isEmpty()){
			for(int i=0; i<dataList.size();i++) {
				slot = new SlotBookings();
				Object[] row = (Object[])dataList.get(i);
				slot.setVideoId((Integer)row[0]);
				slot.setLocId((Integer)row[1]);
				slot.setSlotDate((java.sql.Date)row[2]);
				slot.setSlotTime((java.sql.Time)row[3]);
				slot.setSumBkdSlots((java.math.BigDecimal)row[4]);
				slot.setSumRepats((java.math.BigDecimal)row[5]);
				slotList.add(slot);
			}
		}
		return slotList;
	}
	
	public IBSlotTrackerDtl save(IBSlotTrackerDtl slot){
		return entityManager.merge(slot);
	}
	
	public IBSlotTrackerDtl getSlotTracker(int id){
		String qry ="from IBSlotTrackerDtl  where trackerId = "+id;
		return (IBSlotTrackerDtl)entityManager.createQuery(qry).getSingleResult();
	}
	
	public void delete(IBSlotTrackerDtl tracker){
		entityManager.remove(tracker);
	}
}
