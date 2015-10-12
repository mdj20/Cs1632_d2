import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class DriverTest {

	static CityLayout testCity;
	static ArrayList<CityLocation> locations;
	static ArrayList<Street> streets; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		locations = DataDefault.defaultCityLocInfo();
		streets = DataDefault.defaultStreetInfo();		
		testCity = new CityLayout(DataDefault.x,DataDefault.y,locations,streets);	
		DataDefault.addSpawnPoints(testCity, locations);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
