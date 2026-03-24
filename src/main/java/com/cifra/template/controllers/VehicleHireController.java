package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {

	@GetMapping("/vehicle-hires")
	public String getCountries() {
		return "vehicle-hire";
	}

	
}
