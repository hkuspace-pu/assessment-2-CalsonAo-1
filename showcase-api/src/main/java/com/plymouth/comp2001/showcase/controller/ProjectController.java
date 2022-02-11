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
import com.plymouth.comp2001.showcase.model.Project;
import com.plymouth.comp2001.showcase.model.ProjectRepository;

@RestController
public class ProjectController
{
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectRepository repository;
	
	@PostMapping("/projects")
	public int add(@RequestBody Project project)
	{
		logger.info("create project: {}", project.toString());
		int result = repository.insert(project);
		return result;
	}
	
	@GetMapping("/projects")
	public List<Project> list()
	{
		List<Project> list = repository.findAll();
		logger.info("retrieve all projects, total: {}", list.size());
		for (int i = 0; i < list.size(); i++)
		{
			Project project = list.get(i);
			logger.info("p[{}]: {}", i, project.toString());
		}
		return list;
	}

//	@GetMapping("/projects/{id}")
//	public Project getProjectById(@PathVariable(value = "id") Long projectId) {
//		Optional<Project> optional = projectRepository.findById(projectId);
//		Project project = optional.orElse(null);
//		return project;
//	}
	
	@PutMapping("/projects/{projectId}")
	public int update(@PathVariable(value = "projectId") Integer projectId, @RequestBody Project project) {

		logger.info("update project {} to {}", projectId, project.toString());
		int result = repository.update(projectId, project);
		return result;
	}

	@DeleteMapping("/projects/{projectId}")
	public int delete(@PathVariable Integer projectId)
	{
		logger.info("delete programme {}", projectId);
		int result = repository.delete(projectId);
		return result;
	}
}
