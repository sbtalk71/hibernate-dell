package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	//http://host:port/greet/Scott
	@RequestMapping(path="/greet/{name}", method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> greet(@PathVariable("name")String username) {
	return ResponseEntity.ok("Hello from Spring REST for "+username);
		//return ResponseEntity.status(401).build();
	}
}
