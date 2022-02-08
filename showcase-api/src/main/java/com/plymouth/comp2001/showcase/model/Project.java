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
	
	@Column(nullable = false, updatable = false)
	private String title;
	
	@Column
	private String description;
	
	@Column
	private Integer year;
	
	private String thumbnailImage;
	
	private String posterImage;
	
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createTime;
	
	@Column(nullable = true, updatable = true)
	private LocalDateTime lastUpdateTime;
	
	public Project()
	{
		
	}
	
	public Project(Integer projectId, String title)
	{
		this.projectId = projectId;
		this.title = title;
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

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Integer getYear()
	{
		return year;
	}

	public void setYear(Integer year)
	{
		this.year = year;
	}

	public String getThumbnailImage()
	{
		return thumbnailImage;
	}

	public void setThumbnailImage(String thumbnailImage)
	{
		this.thumbnailImage = thumbnailImage;
	}

	public String getPosterImage()
	{
		return posterImage;
	}

	public void setPosterImage(String posterImage)
	{
		this.posterImage = posterImage;
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
