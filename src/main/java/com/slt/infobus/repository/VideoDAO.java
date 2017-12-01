package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBVideoDtl;

@Repository
@Transactional
public class VideoDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBServerDtl").getResultList();
	}
	public IBVideoDtl save(IBVideoDtl server){
		return entityManager.merge(server);
	}
}
