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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer code;
	
	@Column(nullable = false, updatable = true)
	private String title;
	
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createTime;
	
	@Column(nullable = true, updatable = true)
	private LocalDateTime lastUpdateTime;
	
	public Programme()
	{
	}
	
	public Programme(Integer code, String title)
	{
		this.code = code;
		this.title = title;
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
