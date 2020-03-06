/**
 * 
 */
package main.java.com.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author singha
 *
 */
public class Tests {

	StringToInteger algos;
	NextGreaterNumberToTheRight ngnRight;

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		algos = new StringToInteger();
		ngnRight = new NextGreaterNumberToTheRight();
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAllIntegers() {

		int result = algos.convertStringToInteger("4567");
		System.out.println(algos.convertStringToInteger("4567"));

		assertEquals("Result: " + result + " Expected: " + 4567, 4567, result);

	}
	
	@Test
	public void testWithAMinusSignAtAfterFirstPositionAndInTheMiddle() {

		int result = algos.convertStringToInteger("45-67");
		System.out.println(algos.convertStringToInteger("45-67"));

		assertEquals("Result: ", 67, result);
	}
	
	@Test
	public void testWithAMinusSignAtAfterFirstPosition() {

		int result = algos.convertStringToInteger("4567-");
		System.out.println(algos.convertStringToInteger("4567-"));

		assertEquals("Result: " + result + " Expected: " + 0, 0, result);
	}
	
	@Test
	public void testWithAMinusSignAtBeginning() {

		int result = algos.convertStringToInteger("-4567");
		System.out.println(algos.convertStringToInteger("-4567"));

		assertEquals("Result: ", -4567, result);
	}
	
	@Test
	public void testFindNextBiggerNumber() {
		
		int [] input = {4, 1, 8, 3, 5, 0};
		
		System.out.println("Result from testFindNextBiggerNumber with input : "
				+ input + "\n" + ngnRight.findNextBiggerNumberOptimized(input));
	}

}
