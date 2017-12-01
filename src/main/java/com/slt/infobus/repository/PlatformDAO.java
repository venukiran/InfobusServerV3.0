package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBPlatformDtl;

@Repository
@Transactional
public class PlatformDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public IBPlatformDtl save(IBPlatformDtl entity){
		return entityManager.merge(entity);
	}
	public List getAll(){
		return entityManager.createQuery("from IBPlatformDtl").getResultList();
	}
}
