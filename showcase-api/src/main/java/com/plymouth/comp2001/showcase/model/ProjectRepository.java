package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository
{
	@PersistenceContext
	private EntityManager em;
	
	public List<Project> findAll()
	{
		Query query = em.createNativeQuery("select * from project", Project.class);
		List<Project> list = (List<Project>) query.getResultList();
		return list;
	}
	
	@Transactional
	public int insert(Project project) {
		Query query = em.createNativeQuery("insert into project (title, description, year, create_time) values (:title, :description, :year, :create_time)");
		query.setParameter("title", project.getTitle());
		query.setParameter("description", project.getDescription());
		query.setParameter("year", project.getYear());
		query.setParameter("create_time", LocalDateTime.now());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int update(Integer projectId, Project project) {
		Query query = em.createNativeQuery("update project set title=:title, description=:description, year=:year, last_update_time=:last_update_time where project_id = :project_id");
		query.setParameter("project_id", projectId);
		query.setParameter("title", project.getTitle());
		query.setParameter("description", project.getDescription());
		query.setParameter("year", project.getYear());
		query.setParameter("last_update_time", LocalDateTime.now());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int delete(Integer projectId) {
		Query query = em.createNativeQuery("delete from project where project_id = :project_id");
		query.setParameter("project_id", projectId);
		int result = query.executeUpdate();
		return result;
	}
}
