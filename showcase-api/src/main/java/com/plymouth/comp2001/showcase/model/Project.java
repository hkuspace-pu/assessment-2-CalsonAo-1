package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;

public class Project
{
	private Integer projectId;
	private String projectName;
	private LocalDateTime dateTime;
	
	public Project()
	{
		this.dateTime = LocalDateTime.now();
	}
	
	public Project(Integer projectId, String projectName)
	{
		this();
		this.projectId = projectId;
		this.projectName = projectName;
	}
	
	public Integer getProjectId()
	{
		return projectId;
	}
	public void setProjectId(Integer projectId)
	{
		this.projectId = projectId;
	}
	public String getProjectName()
	{
		return projectName;
	}
	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}
	public LocalDateTime getDateTime()
	{
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime)
	{
		this.dateTime = dateTime;
	}
}
