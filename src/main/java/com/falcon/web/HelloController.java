package com.falcon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.service.SomeService;

@RestController
public class HelloController {

	@Autowired
	private SomeService service;
	
	@RequestMapping(value = "/hello")
	public String hello() {
		String result = service.getInfo();
		return result;
	}
	
}
