package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBServerDtl;

@Repository
@Transactional
public class ServerDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<IBServerDtl> findAll(){
		return entityManager.createQuery("from IBServerDtl").getResultList();
	}
	
	public List<IBServerDtl> findByLocation(String loc){
		return entityManager.createQuery("from IBServerDtl s where s.locationId="+loc).getResultList();
	}
	
	public IBServerDtl save(IBServerDtl server){
		return entityManager.merge(server);
	}
}
