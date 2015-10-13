import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class CityLocationTest {

	static ArrayList<CityLocation> doubleLocations;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		// test values
		doubleLocations = new ArrayList<CityLocation>();
		boolean inCityToggle = false;
		
		//create doubles for data test
		for( int i = 0 ; i < 100 ; i++ ){
			
			inCityToggle = (i % 2 == 0) ?  false: true;
			doubleLocations.add(new CityLocation(new String(Integer.toString(i)),i,i,inCityToggle));
	
		}
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testX() {
		
		// num of tests
		int iteration = 100;
		
		// test values
		int expected[] = new int [iteration];
		int actual[] = new int[iteration];
		
		// run tests
		for( int i = 0 ; i < iteration ; i++ ){
			expected[i] = i;
			actual[i] = doubleLocations.get(i).x();
		
		}
		
		assertArrayEquals(expected,actual);
		
		
	}

	@Test
	public void testY() {
		
		// num of tests
		int iteration = 100;
		
		// test values
		int expected[] = new int [iteration];
		int actual[] = new int[iteration];
		
		// run tests
		for( int i = 0 ; i < iteration ; i++ ){
			
		
			expected[i] = i;
			actual[i] = doubleLocations.get(i).y();
		
		}
		
		assertArrayEquals(expected,actual);
		
	}

	@Test
	public void testName() {
		
		// num of tests
		int iteration = 100;
		
		// test values
		String expected[] = new String[iteration];
		String actual[] = new String[iteration];
		
		// run tests
		for( int i = 0 ; i < iteration ; i++ ){
		
			expected[i] = new String(Integer.toString(i));
			actual[i] = doubleLocations.get(i).name();
			
		}
		
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testInCity() {
		
		// num of tests
		int iteration = 100;
		
		// test values
		boolean expected[] = new boolean[iteration];
		boolean actual[] = new boolean[iteration];
		
		// required for differentiation 
		boolean inCityToggle = false;
		
		// run tests
		for( int i = 0 ; i < iteration ; i++ ){
			
			inCityToggle = (i % 2 == 0) ?  false: true;
			
			expected[i] = inCityToggle;
			actual[i] = doubleLocations.get(i).inCity();
		
		}
		
		
		// final check for consistancy 
		boolean checkVal = true;
		for( int i = 0 ; i < iteration ; i++ ){
		
			if (expected[i] != actual[i] ){
				checkVal = false;
			}
			
		}
		
		//assertTrue 
		assertTrue(checkVal);
	}

}
