package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMakeController {

	@GetMapping("/vehicle-makes")
	public String getCountries() {
		return "vehicle-make";
	}

	
}
