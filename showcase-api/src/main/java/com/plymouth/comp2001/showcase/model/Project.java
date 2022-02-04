package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	
	@Column(nullable = false, updatable = true)
	private String projectName;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createTime;
	
	@Column(nullable = true, updatable = true)
	private LocalDateTime lastUpdateTime;
	
	public Project()
	{
		
	}
	
	public Project(Integer projectId, String projectName)
	{
		this.projectId = projectId;
		this.projectName = projectName;
	}
	
	@PrePersist
	protected void onCreate()
	{
		this.createTime = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		lastUpdateTime = LocalDateTime.now();
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
	public LocalDateTime getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime)
	{
		this.createTime = createTime;
	}
	public LocalDateTime getLastUpdateTime()
	{
		return lastUpdateTime;
	}
	public void setLastUpdateTime(LocalDateTime lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}
}
