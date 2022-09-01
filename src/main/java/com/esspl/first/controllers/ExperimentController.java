package com.esspl.first.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex")
public class ExperimentController {

	@GetMapping("/school")
	public String school() {
		return "this is my school !!";
	}
	
	@GetMapping("/diploma")
	public String diploma() {
		return "this is my diploma certificate !!";
	}
	
	@GetMapping("/graduation")
	public String graduation() {
		return "this is my graduation !!";
	}
	
	
	
	
	
}
