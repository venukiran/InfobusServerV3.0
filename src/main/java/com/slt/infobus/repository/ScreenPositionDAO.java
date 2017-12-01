package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBScreenPositionDtl;

@Repository
@Transactional
public class ScreenPositionDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBScreenPositionDtl").getResultList();
	}
	public IBScreenPositionDtl save(IBScreenPositionDtl screenpos){
		return entityManager.merge(screenpos);
	}
}
