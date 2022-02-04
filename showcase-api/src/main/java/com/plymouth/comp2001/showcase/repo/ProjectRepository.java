package com.plymouth.comp2001.showcase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.plymouth.comp2001.showcase.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>
{
	
}
