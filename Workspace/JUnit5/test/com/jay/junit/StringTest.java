package com.jay.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

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
	
	
	/** this is run before all tests */
	@BeforeAll
	static void beforeAll() { /** ++++++++++MUST BE STATIC +++++++++++ */
		System.out.println("--- this is run before all tests ---");
		//maybe open a connection to a database here 
	}
	
	/** this is run after all tests */
	@AfterAll
	static void afterAll() { /** ++++++++++MUST BE STATIC +++++++++++ */
		System.out.println("--- this is run after all tests ---");
		//maybe close a connection to a database here
	}
	
	//--------------------
	
	/** this is run before the start of each @Test to set conditions */
	@BeforeEach //called @Before in jUnit4
	void beforeEach(TestInfo testInfo) {
		System.out.println("initialise test data for: " + testInfo.getDisplayName());
	}
	
	
	/** this is run after the start of each @Test*/
	@AfterEach //called @After in jUnit4
	void afterEach(TestInfo testInfo) {
		System.out.println("do something you'd want to do after: " + testInfo.getDisplayName());
	}
	
	//---------------------
	
	
	@Test //this annotation is what makes this a test method - NOT the method name
	//comes from: import org.junit.jupiter.api.Test;
	void testExample1() {
		
		//this test fails when run as fail is passed "not yet implemented"
		/** if fail is REMOVED then test is successs. i.e ABSENCE OF FAIL GIVES SUCCESS */
		// fail comes from: org.junit.jupiter.api.Assertions.*;
		////////////////fail("Not yet implemented");
		
		/** checks MUST be implemented for test to be achieved. Checks are called ASSERTIONS. (like fail() above)*/
		
		/**------------- Example 1 ---------------------------------------------------------:
		 * 
		 * 1: invoke a method that returns square root of 4
		 * eg: square(4); 
		 * This is called the CODE UNDER TEST (CUT)
		 * 
		 * 2: Have a check (Assertion) in place that checks that the returned result is 16
		 * 
		 */
		
	}
	
	@Test
	/** +++++++++++ DISPLAY NAME - shows this instead of the usual name for the method when run ++++++++++++ */
	@DisplayName("Im a display name for this method!") 
	void lengthTest() {
		
		int actualLength = "ABCD".length(); //actual output
		int expectedLength = 4; //expected output
		
		/** once you have an actual output AND and expected output, then you can write assertions on them */
		
		//this assertion checks that both values are equal:
		assertEquals(expectedLength, actualLength); /** put in expected THEN actual */
		
		
		//assert that length == 4. Without this assertion THIS TEST WILL SUCCEED even if .length actually returned 3 for example!
	}
	
	
	/** Testing EXPECTED Exceptions (11. step 9 on course)*/
	@Test
	void lengthExceptionTest() {
		String str = null;
		
		//(class of exception your expecting, supplier with code that creates that exception)
		assertThrows(NullPointerException.class, ()-> {
			
			str.length(); /** throws execption */ 
			// plus more lines if necessary.. (hense body given to lambda!)
		});
	}
	
	@Test
	void toUpperCaseTest() {
		
		String string = "abcd";
		String result = string.toUpperCase();
		assertEquals("ABCD", result); //assert that result is uppercase
		
		assertNotNull(result); //assert that result ISNT null
		//// assertNull(result); //assert that result IS null - this obv fails!
	}
	

	@Test
	void contains() {
		
		String string = "abcdefgh";
		boolean result = string.contains("ijk");
		assertEquals(false, result); //check that result is false
		//assertEquals(true, result); //check that result is true - this obv fails!
		
		/** better way than essertEquals for booleans: */
		assertFalse(result);
		//assertTrue(result); - this obv fails!
	}
	
	
	@Test
	void assertionsForArrays() {
		
		String str = "abc def jhi";
		String [] actualResult = str.split(" ");
		String [] expectedResult = new String[] {"abc", "def", "jhi"};
		
		assertArrayEquals(expectedResult, actualResult);
	}
	
	
}