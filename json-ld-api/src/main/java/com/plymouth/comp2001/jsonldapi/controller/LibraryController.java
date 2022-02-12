package com.plymouth.comp2001.jsonldapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.plymouth.comp2001.jsonldapi.model.LibraryJson;
import com.plymouth.comp2001.jsonldapi.service.LibraryService;

@Controller
public class LibraryController
{
	@Autowired
	private LibraryService service;
	
	@GetMapping("/library/list")
    public String listLibrary(Model model) {
		List<LibraryJson> libraryList = service.getLibraryJsonList();
        model.addAttribute("libraryList", libraryList);
        return "library_list";
    }
}
