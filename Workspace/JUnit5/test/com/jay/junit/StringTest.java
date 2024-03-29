package com.jay.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;




//======================BEST PRACTICES ===============================

/*
 * 1: Readable - One look at the test should tell what is being tested!
 * 2: Fast - What happens if the unit test takes too long to run?
 * 3: Isolated - Fails ONLY when there is an issue with the code
 * 4: Run Often - What is the use of having unit tests that are not run frequesntly?
 * 
 * Recommended further reading: 
 * xunitpatterns.com
 * 
 */


/**
 * 
 * 1: make new source folder (test) - ALWAYS SEPERATE TEST CODE FROM PRODUCTION CODE
 * 2: make new Junit test case. use juint 'jupiter' (junit5) - create package
 * 3: add jUnit build path
 * 4: to run: rightclick > run as junit test
 * 
 *
 */

// @Disabled //- disables ALL of the tests in this test class 
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
	
	
	//--------------------------------
	
	/** +++++++++++++++++PARAMETERIZED TEST - using same test with different types of data +++++++++++++++++++ */
	
	@ParameterizedTest
	@ValueSource(strings = {"ABCD", "ABC", "BC", "D", "DEF"}) //collection of values you want to test (int, long and double also)
	void lengthGreaterThanZero(String str) {
		assertTrue(str.length() >0);
	}
	
	
	/** +++++++++++++++parameterized test with CSV (comma separated values) source ++++++++  
	 * NOTE: empty values are counted as NULL so cause fail. so use single quotes like last expected and actual value, shown below */
	
	@ParameterizedTest(name = "{1} is capitalised to: {0}") /** ++++++++++++++++++++GIVING A NAME TO PARAMETERIZED TEST +++++++ */
	@CsvSource(value= {"ABCD, abcd", "BCD, bcd", "NYAHOI, nyahoi", "'', ''"}) /** 4 sets of expected and actuals */
	void upperCase(String capitalizedString, String string) {
		assertEquals(capitalizedString, string.toUpperCase()); //expected, actual
	}
	
	
	/**++++++++++++++++++Repeat same test multiple times ++++++++++++++++++ */
	
	@RepeatedTest(10) /** repeat this test 10 times */
	void runMultipleTimes() {
		assertEquals(false, false);
	}
	

	/** ++++++++++++++Performance testing +++++++++++++ */
	
	@Test
	@Disabled /** ++++++++++++++++++++++Disable test - called @Ignored in junit4 ++++++++++++++++++++*/
	void performanceTest() {
		
		//takes: (duration you want test to run within, thing to test)
		assertTimeout(Duration.ofSeconds(5), ()->{
			//thing to test:
			for(int i=0;i<=10;i++) {
				System.out.println(i);
			};
		});
	}
	
	
	//+++++++++++++++====================GROUPING TESTS WITH @NESTED ===================+++++++++++++++++++++++++
	
	
	private String myString;
	
	@Nested
	@DisplayName("Tests for an empty string")
	class EmptyStringTests {
		
		//before each test, set string to empty
		@BeforeEach
		void setToEmpty() {
			myString = "";
		}
		
		//test 1:
		@Test
		@DisplayName("Length should be zero")
		void lengthIsZero() {
			assertEquals(0, myString.length()); //(expected, actual)
		}
		
		//test2: 
		@Test
		@DisplayName("uppercase should be empty")
		void upperCaseIsEmpty() {
			assertEquals("", myString.toUpperCase()); 
		}
	}
	
	
	
	
	
	
	
}