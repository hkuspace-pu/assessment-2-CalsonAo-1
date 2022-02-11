package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "programme")
public class Programme
{
	@Id													// the primary key column
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// each table has its own ID generator
//	@GeneratedValue(strategy = GenerationType.AUTO)		// all table use a single ID generator
	private Integer code;
	
	@Column(name="title", nullable=false)
	private String title;
	
	
	@Column(name="create_time", nullable=false, updatable=false)
	private LocalDateTime createTime;
	
	@Column(name = "last_update_time")
	private LocalDateTime lastUpdateTime;
	
	public Programme()
	{
	}

	@Override
	public String toString()
	{
		String body = ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
		return body;
	}
	
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

	public LocalDateTime getLastUpdateTime()
	{
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LocalDateTime lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}
}
