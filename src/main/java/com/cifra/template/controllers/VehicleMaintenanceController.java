package com.cifra.template.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {
	
	@GetMapping("/vehicle-maintenances")
	public String getCountries() {
		return "vehicle-maintenance";
	}


}
