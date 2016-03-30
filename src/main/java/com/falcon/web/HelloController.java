package com.falcon.web;

import java.util.Random;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/hello")
	public String hello() {
		return getInfo();
	}
	
	@Retryable(maxAttempts=3, backoff=@Backoff(delay=5000, multiplier=2))
	private String getInfo() {
		Random random = new Random();
		int r = random.nextInt(2);
		if( r == 1) {
			throw new RuntimeException();
		} else {
			return "hello";
		}
	}
}
