package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeTypeController {
	
	@GetMapping("/employee-types")
	public String getCountries() {
		return "employee-type";
	}


}
