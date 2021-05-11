package com.jay.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * 
 * 1: make new source folder (test) - ALWAYS SEPERATE TEST CODE FROM PRODUCTION CODE
 * 2: make new Junit test case. use juint 'jupiter' (junit5) - create package
 * 3: add jUnit build path
 * 4: to run: rightclick > run as junit test
 * 
 *
 */
class StringTest {

	@Test //this annotation is what makes this a test method - NOT the method name
	//comes from: import org.junit.jupiter.api.Test;
	void test() {
		
		//this test fails when run as fail is passed "not yet implemented"
		/** if fail is REMOVED then test is successs. i.e ABSENCE OF FAIL GIVES SUCCESS */
		// fail comes from: org.junit.jupiter.api.Assertions.*;
		fail("Not yet implemented");
		
		/** checks MUST be implemented for test to be achieved. Checks are called ASSERTIONS. (like fail() above)*/
		
	}

}
