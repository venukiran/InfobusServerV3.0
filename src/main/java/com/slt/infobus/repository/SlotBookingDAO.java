package com.slt.infobus.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBSlotBookingDtl;

@Repository
@Transactional
public class SlotBookingDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List findAll(){		
		return entityManager.createQuery("from IBSlotBookingDtl").getResultList();
	}
	
	public List findAllByLocation(String locId){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date cal = new Date();//Calendar.getInstance();
		String date = dateFormat.format(cal);
		String qry = "from IBSlotBookingDtl s where s.locationId="+locId+" and '"+date+"' between start_date and end_date order"; // by s.displayOrder";
		return entityManager.createQuery(qry).getResultList();
	}
	
	public IBSlotBookingDtl save(IBSlotBookingDtl slot){
		return entityManager.merge(slot);
	}
	
	public IBSlotBookingDtl getSlotBooking(int id){
		String qry ="from IBSlotBookingDtl  where slotBookId = "+id;
		return (IBSlotBookingDtl)entityManager.createQuery(qry).getSingleResult();
	}
	
	public void delete(IBSlotBookingDtl server){
		entityManager.remove(server);
	}
}
