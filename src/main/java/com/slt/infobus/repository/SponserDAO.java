package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBLocationDtl;
import com.slt.infobus.entity.IBServerDtl;
import com.slt.infobus.entity.IBSponserDtl;

@Repository
@Transactional
public class SponserDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBSponserDtl").getResultList();
	}
	public IBSponserDtl save(IBSponserDtl sponser){
		return entityManager.merge(sponser);
	}
}
