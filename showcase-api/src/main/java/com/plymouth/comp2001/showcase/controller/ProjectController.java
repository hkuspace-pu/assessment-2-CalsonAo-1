package com.plymouth.comp2001.showcase.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.plymouth.comp2001.showcase.config.AppYml;
import com.plymouth.comp2001.showcase.model.Project;
import com.plymouth.comp2001.showcase.repo.ProjectRepository;

@RestController
public class ProjectController
{
	@Value("${server.port}")
	private int port;
	
	@Autowired
	private AppYml ymlConfig;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/list")
	public List<Project> list()
	{
		List<Project> list = projectRepository.findAll();
		return list;
	}
	
	@GetMapping("/add")
	public Project add()
	{
		Project project = new Project();
//		project.setTitle("Biohazard 3");
//		project.setTitle("Dino Crisis 2");
		project.setTitle("Devil May Cry 4");
		project = projectRepository.save(project);
		return project;
	}
	
	@PostMapping("/create")
	public Project createProject(@RequestBody Project project) {
		project = projectRepository.save(project);
		return project;
	}
	
	@GetMapping("/project/{id}")
	public Project getProjectById(@PathVariable(value = "id") Long projectId) {
		Optional<Project> optional = projectRepository.findById(projectId);
		Project project = optional.orElse(null);
		return project;
	}
	
	@PutMapping("/project/{id}")
	public Project updateProject(@PathVariable(value = "id") Long projectId, @RequestBody Project project) {

		Optional<Project> optional = projectRepository.findById(projectId);
		Project dbProject = optional.orElse(null);
		dbProject.setTitle(project.getTitle());
		dbProject = projectRepository.save(dbProject);
		return dbProject;
	}

	@DeleteMapping("/project/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable(value = "id") Long projectId) {
		Optional<Project> optional = projectRepository.findById(projectId);
		Project dbProject = optional.orElse(null);
		projectRepository.delete(dbProject);
		return ResponseEntity.ok().build();
	}
}
