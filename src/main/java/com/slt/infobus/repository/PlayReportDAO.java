package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBPlayReportDtl;

@Repository
@Transactional
public class PlayReportDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBPlayReportDtl").getResultList();
	}
	
	public IBPlayReportDtl getLocation(String id){
		return (IBPlayReportDtl) entityManager.createQuery("from IBPlayReportDtl where playId="+id).getSingleResult();
	}
	public IBPlayReportDtl save(IBPlayReportDtl loc){
		return entityManager.merge(loc);
	}
}
