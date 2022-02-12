package com.plymouth.comp2001.jsonldapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.plymouth.comp2001.jsonldapi.service.LibraryService;

@RestController
public class LibraryJsonLdRestController
{
	private static final Logger logger = LoggerFactory.getLogger(LibraryJsonLdRestController.class);
	
	@Autowired
	private LibraryService service;
	
	@GetMapping(value = "/library/jsonld", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getLibraryJsonLd()
	{
		logger.info("retrieving library json-ld...");
		String jsonLdStr = service.getLibraryJsonLdStr();
		return jsonLdStr;
	}
}
