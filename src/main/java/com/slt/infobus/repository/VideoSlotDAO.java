package com.slt.infobus.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBVideoSlotDtl;

@Repository
@Transactional
public class VideoSlotDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List findAll() throws Exception{		
		return entityManager.createQuery("from IBVideoSlotDtl").getResultList();
	}
	
	public List findAllByLocation(String locId) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date cal = new Date();//Calendar.getInstance();
		String date = dateFormat.format(cal);
		String qry = "from IBVideoSlotDtl s where s.locationId="+locId+" and '"+date+"' between start_date and end_date order by s.displayOrder";
		return entityManager.createQuery(qry).getResultList();
	}
	
	public IBVideoSlotDtl save(IBVideoSlotDtl slot) throws Exception{
		return entityManager.merge(slot);
	}
}
