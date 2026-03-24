package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleTypeController {
	
	@GetMapping("/vehicle-types")
	public String getCountries() {
		return "vehicle-type";
	}


}
