package com.plymouth.comp2001.showcase.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.plymouth.comp2001.showcase.model.Programme;
import com.plymouth.comp2001.showcase.model.ProgrammeRepository;

@RestController
public class ProgrammeController
{
	private static final Logger logger = LoggerFactory.getLogger(ProgrammeController.class);
	
	@Autowired
	private ProgrammeRepository repository;
	
	@PostMapping("/programmes")
	public int add(@RequestBody Programme programme)
	{
		logger.info("create programme: {}", programme.toString());
		int result = repository.insert(programme);
		return result;
	}
	
	@GetMapping("/programmes")
	public List<Programme> list()
	{
		List<Programme> list = repository.findAll();
		logger.info("retrieve all programmes, total: {}", list.size());
		for (int i = 0; i < list.size(); i++)
		{
			Programme programme = list.get(i);
			logger.info("p[{}]: {}", i, programme.toString());
		}
		return list;
	}
	
	@PutMapping("/programmes/{code}")
	public int update(@PathVariable Integer code, @RequestBody Programme programme)
	{
		logger.info("update programme {} to {}", code, programme.toString());
		int result = repository.update(code, programme);
		return result;
	}
	
	@DeleteMapping("/programmes/{code}")
	public int delete(@PathVariable Integer code)
	{
		logger.info("delete programme {}", code);
		int result = repository.delete(code);
		return result;
	}
}
