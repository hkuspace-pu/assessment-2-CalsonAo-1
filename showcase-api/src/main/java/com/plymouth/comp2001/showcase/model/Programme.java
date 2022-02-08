package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;

public class Programme
{
	private Integer code;
	private String title;
	private LocalDateTime createTime;
	private LocalDateTime lastUpdateTime;
	
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
