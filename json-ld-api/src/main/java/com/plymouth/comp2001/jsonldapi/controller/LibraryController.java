package com.plymouth.comp2001.jsonldapi.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.plymouth.comp2001.jsonldapi.model.LibraryJson;
import com.plymouth.comp2001.jsonldapi.service.LibraryService;

@Controller
public class LibraryController
{
	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class); 
	
	@Autowired
	private LibraryService service;
	
	@GetMapping("/")
    public String home(Model model) {
		logger.info("go to homepage!");
		model.addAttribute("datasetUrl", service.getDatasetUrl());
        return "home";
    }
	
	@GetMapping("/list")
    public String listLibrary(Model model) {
		logger.info("go to list page!");
		List<LibraryJson> libraryList = service.getLibraryJsonList();
        model.addAttribute("libraryList", libraryList);
        return "library_list";
    }
}
