package com.plymouth.comp2001.showcase.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.plymouth.comp2001.showcase.model.Student;
import com.plymouth.comp2001.showcase.model.StudentRepository;

@RestController
public class StudentController
{
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository repository;
	
	@PostMapping("/students")
	public int add(@RequestBody Student student)
	{
		logger.info("create student: {}", student.toString());
		int result = repository.insert(student);
		return result;
	}
	
	@GetMapping("/students")
	public List<Student> list()
	{
		List<Student> list = repository.findAll();
		logger.info("retrieve all students, total: {}", list.size());
		for (int i = 0; i < list.size(); i++)
		{
			Student student = list.get(i);
			logger.info("p[{}]: {}", i, student.toString());
		}
		return list;
	}
	
	@PutMapping("/students/{studentId}")
	public int update(@PathVariable Integer studentId, @RequestBody Student student)
	{
		logger.info("update student {} to {}", studentId, student.toString());
		int result = repository.update(studentId, student);
		return result;
	}
	
	@DeleteMapping("/students/{studentId}")
	public int delete(@PathVariable Integer studentId)
	{
		logger.info("delete student {}", studentId);
		int result = repository.delete(studentId);
		return result;
	}
}
