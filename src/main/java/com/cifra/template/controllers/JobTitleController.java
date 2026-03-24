package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobTitleController {
	
	@GetMapping("/job-titles")
	public String getCountries() {
		return "job-title";
	}


}
