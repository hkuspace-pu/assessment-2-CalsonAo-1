package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProgrammeRepository
{
	@PersistenceContext
	private EntityManager em;
	
	public List<Programme> findAll()
	{
		Query query = em.createNativeQuery("select * from programme", Programme.class);
		List<Programme> programList = (List<Programme>) query.getResultList();
		return programList;
	}
	
	@Transactional
	public int insert(Programme programme) {
		
		// native query
//		Query query = em.createNativeQuery("insert into programme (title, create_time) values (:title, :create_time)");
//		query.setParameter("title", programme.getTitle());
//		query.setParameter("create_time", LocalDateTime.now());
//		int result = query.executeUpdate();
//		return result;
		
		// call store procedure
		Query query = em.createNativeQuery("{call Create_Programme(?)}");           
		query.setParameter(1, programme.getTitle());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int update(Integer code, Programme programme) {
		// native query
//		Query query = em.createNativeQuery("update programme set title=:title, last_update_time=:last_update_time where code = :code");
//		query.setParameter("code", code);
//		query.setParameter("title", programme.getTitle());
//		query.setParameter("last_update_time", LocalDateTime.now());
//		int result = query.executeUpdate();
//		return result;
		
		// call store procedure
		Query query = em.createNativeQuery("{call Update_Programme(?, ?)}");           
		query.setParameter(1, code);
		query.setParameter(2, programme.getTitle());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int delete(Integer code) {
		// native query
//		Query query = em.createNativeQuery("delete from programme where code = :code");
//		query.setParameter("code", code);
//		int result = query.executeUpdate();
//		return result;
		
		// call store procedure
		Query query = em.createNativeQuery("{call Delete_Programme(?)}");           
		query.setParameter(1, code);
		int result = query.executeUpdate();
		return result;
	}
}
