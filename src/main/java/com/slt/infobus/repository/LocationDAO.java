package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBLocationDtl;

@Repository
@Transactional
public class LocationDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from busdetails").getResultList();
	}
	
	public IBLocationDtl getLocation(String id){
		return (IBLocationDtl) entityManager.createQuery("from IBLocationDtl where locationId="+id).getSingleResult();
	}
	public IBLocationDtl save(IBLocationDtl loc){
		return entityManager.merge(loc);
	}
}
