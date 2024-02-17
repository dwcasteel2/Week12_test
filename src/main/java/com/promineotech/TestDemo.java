package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	//Add Positive
	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0) {
			int sum = a + b;
			return sum;
		}else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public int subtractPositive(int d, int e) {
		
		if(d > 0 && e > 0) {
			int subtract = d - e;
			return subtract;
		}else {
			throw new IllegalArgumentException("Both numbers need to be positive.");
		}
	}
	
	public int randomNumberSquared() {
		return getRandomInt() * getRandomInt();
	}
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	

}
