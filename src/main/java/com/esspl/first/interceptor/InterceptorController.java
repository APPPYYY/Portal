package com.esspl.first.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {

	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/interceptor")
	public String first() {
		logger.info("INSIDE -CONTROLLER");
		return "I AM SUBHAM";
	}
}
