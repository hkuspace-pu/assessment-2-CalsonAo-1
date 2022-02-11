package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository
{
	@PersistenceContext
	private EntityManager em;
	
	public List<Student> findAll()
	{
		Query query = em.createNativeQuery("select * from student", Student.class);
		List<Student> list = (List<Student>) query.getResultList();
		return list;
	}
	
	@Transactional
	public int insert(Student student) {
		Query query = em.createNativeQuery("insert into student (name, create_time) values (:name, :create_time)");
		query.setParameter("title", student.getName());
		query.setParameter("create_time", LocalDateTime.now());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int update(Integer studentId, Student student) {
		Query query = em.createNativeQuery("update student set name=:name, last_update_time=:last_update_time where student_id = :student_id");
		query.setParameter("student_id", studentId);
		query.setParameter("name", student.getName());
		query.setParameter("last_update_time", LocalDateTime.now());
		int result = query.executeUpdate();
		return result;
	}
	
	@Transactional
	public int delete(Integer studentId) {
		Query query = em.createNativeQuery("delete from student where student_id = :student_id");
		query.setParameter("student_id", studentId);
		int result = query.executeUpdate();
		return result;
	}
}
