package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBLocationDtl;
import com.slt.infobus.entity.IBMsgContentDtl;

@Repository
@Transactional
public class MsgDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<IBMsgContentDtl> findAll(){
		return entityManager.createQuery("from IBMsgContentDtl").getResultList();
	}
	
	public List<IBMsgContentDtl> findAllActive(String loc){
		return entityManager.createQuery("from IBMsgContentDtl m where m.status='Active' and m.location.locationId="+loc).getResultList();
	}
	
	public IBMsgContentDtl save(IBMsgContentDtl loc){
		return entityManager.merge(loc);
	}
}
