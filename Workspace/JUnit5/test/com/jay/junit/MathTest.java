package com.jay.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathTest {
	
	int num1 = 3;
	int num2 = 9;
	
	//testing math.min:
	@Test
	void mathMinTest() {
		
		int expectedMin = num1; //expected output
		int actualMin = Math.min(num1, num2); //actual output
		
		assertEquals(expectedMin, actualMin); /** put in expected THEN actual */
	}
	
	//testing math.max:
	@Test
	void mathMaxTest() {
		
		int expectedMax = num2; //expected output
		int actualMax = Math.max(num1, num2); //actual output
		
		assertEquals(expectedMax, actualMax); /** put in expected THEN actual */
	}

}