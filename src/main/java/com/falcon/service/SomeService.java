package com.falcon.service;

import java.util.Random;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

	@Retryable(maxAttempts=2,value=RuntimeException.class,backoff = @Backoff(delay = 5000,multiplier=2))
	public String getInfo() {
		Random random = new Random();
		int r = random.nextInt(20);
		if (r%2 == 1) {
			System.out.println("Throwing...");
			throw new RuntimeException();
		} else {
			System.out.println("Returning...");
			return "Success";
		}
	}
	
	@Recover
	public String recover(RuntimeException e) {
		System.out.println("Recovering - returning safe value");
		return "Recover";
	}

}
