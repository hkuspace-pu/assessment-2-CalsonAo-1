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
@Table(name = "student")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name="create_time", nullable=false, updatable=false)
	private LocalDateTime createTime;
	
	@Column(name="last_update_time")
	private LocalDateTime lastUpdateTime;
	
	@Override
	public String toString()
	{
		String body = ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
		return body;
	}
	
	public Integer getStudentId()
	{
		return studentId;
	}
	public void setStudentId(Integer studentId)
	{
		this.studentId = studentId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
