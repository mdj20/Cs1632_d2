import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class CityLocationTest {

	static ArrayList<CityLocation> doubleLocations;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		doubleLocations = new ArrayList<CityLocation>();
		
		
		for( int i = 0 ; i < 100 ; i++ ){
			
			doubleLocations.add(new CityLocation(new String(i),))
			
			
		}
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testX() {
		fail("Not yet implemented");
	}

	@Test
	public void testY() {
		fail("Not yet implemented");
	}

	@Test
	public void testName() {
		fail("Not yet implemented");
	}

	@Test
	public void testInCity() {
		fail("Not yet implemented");
	}

}
