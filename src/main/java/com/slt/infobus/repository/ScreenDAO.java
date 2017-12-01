package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBLocationDtl;
import com.slt.infobus.entity.IBScreenDtl;

@Repository
@Transactional
public class ScreenDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBScreenDtl").getResultList();
	}
	public IBScreenDtl save(IBScreenDtl screen){
		return entityManager.merge(screen);
	}
}
