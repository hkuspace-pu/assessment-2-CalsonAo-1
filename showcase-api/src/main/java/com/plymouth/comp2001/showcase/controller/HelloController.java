package com.plymouth.comp2001.showcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plymouth.comp2001.showcase.config.AppYml;
import com.plymouth.comp2001.showcase.model.Project;

@RestController
public class HelloController
{
	@Value("${server.port}")
	private int port;
	
	@Autowired
	private AppYml ymlConfig;
	
	@GetMapping("/aaa")
	public String aaa()
	{
		return "welcome to " + ymlConfig.getPort();
	}
	
	@GetMapping("/bbb")
	public Project bbb()
	{
		Project project = new Project(101, "Biohazard 3");
		return project;
	}
}
