package com.plymouth.comp2001.showcase.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "programme_registration")
public class ProgrammeRegistration
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regId;
	
	@ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "programme_code")
    private Programme programme;

    @Column(name = "register_time")
    private LocalDateTime registerTime;

	public Integer getRegId()
	{
		return regId;
	}

	public void setRegId(Integer regId)
	{
		this.regId = regId;
	}

	public Student getStudent()
	{
		return student;
	}

	public void setStudent(Student student)
	{
		this.student = student;
	}

	public Programme getProgramme()
	{
		return programme;
	}

	public void setProgramme(Programme programme)
	{
		this.programme = programme;
	}

	public LocalDateTime getRegisterTime()
	{
		return registerTime;
	}

	public void setRegisterTime(LocalDateTime registerTime)
	{
		this.registerTime = registerTime;
	}
}
