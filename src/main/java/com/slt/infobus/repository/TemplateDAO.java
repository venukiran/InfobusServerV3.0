package com.slt.infobus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slt.infobus.entity.IBTemplateDtl;

@Repository
@Transactional
public class TemplateDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	public List getAll(){
		return entityManager.createQuery("from IBScreenDtl").getResultList();
	}
	public IBTemplateDtl save(IBTemplateDtl screen){
		return entityManager.merge(screen);
	}
}
