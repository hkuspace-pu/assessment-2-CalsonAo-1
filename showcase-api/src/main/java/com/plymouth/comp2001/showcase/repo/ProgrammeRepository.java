package com.plymouth.comp2001.showcase.repo;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.plymouth.comp2001.showcase.model.Programme;

@Repository
public class ProgrammeRepository
{
	private static final Logger logger = LoggerFactory.getLogger(ProgrammeRepository.class);
	
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
		Query query = em.createNativeQuery("insert into programme (title, create_time) values (:title, :create_time)");
		query.setParameter("title", programme.getTitle());
		query.setParameter("create_time", LocalDateTime.now());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int update(Integer code, Programme programme) {
		Query query = em.createNativeQuery("update programme set title=:title, last_update_time=:last_update_time where code = :code");
		query.setParameter("code", code);
		query.setParameter("title", programme.getTitle());
		query.setParameter("last_update_time", LocalDateTime.now());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int delete(Integer code) {
		Query query = em.createNativeQuery("delete from programme where code = :code");
		query.setParameter("code", code);
		int result = query.executeUpdate();
		return result;
	}
}
