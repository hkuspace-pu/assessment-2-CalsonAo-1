package com.plymouth.comp2001.showcase.model.audit;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit_programme")
public class AuditProgramme
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="create_time", nullable=false, updatable=false)
	private LocalDateTime createTime;
	
	@Column(nullable=false)
	private String action;
	
	@Column(name="code", nullable=false)
	private Integer code;
	
	@Column(name="title", nullable=false)
	private String title;
	
	public Integer getCode()
	{
		return code;
	}
	
	public void setCode(Integer code)
	{
		this.code = code;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public LocalDateTime getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime)
	{
		this.createTime = createTime;
	}
}
