package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@Column(name = "create_time", nullable = false, updatable = false)
	private LocalDateTime createTime;
	
	@Column(name = "last_update_time")
	private LocalDateTime lastUpdateTime;
	
	@OneToMany(mappedBy = "student")
	private Set<ProgrammeRegistration> registrations;
	
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

	public Set<ProgrammeRegistration> getRegistrations()
	{
		return registrations;
	}

	public void setRegistrations(Set<ProgrammeRegistration> registrations)
	{
		this.registrations = registrations;
	}
}
