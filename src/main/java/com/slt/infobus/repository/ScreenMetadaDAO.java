package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBScreenMetadataDtl;

@Repository
@Transactional
public class ScreenMetadaDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBScreenMetadataDtl").getResultList();
	}
	public IBScreenMetadataDtl save(IBScreenMetadataDtl loc){
		return entityManager.merge(loc);
	}
}
