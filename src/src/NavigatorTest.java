import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class NavigatorTest {

	static CityLayout testCity;
	static ArrayList<CityLocation> locations;
	static ArrayList<Street> streets; 
	
	// Sets up required dependencies
	
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

	@Test
	public void testNumberPossibleLocations(){
		
		ArrayList<CityLocation> retLocations =  Navigator.getPossibleLocation( locations.get(7), testCity);
		
		ArrayList<CityLocation> varLocations = new ArrayList<CityLocation>();
		varLocations.add(locations.get(4));
		varLocations.add(locations.get(5));
		varLocations.add(locations.get(6));
		
		System.out.println(retLocations.size());
		for (CityLocation cl : retLocations){
			System.out.println(cl.name()+" "+cl.x()+cl.y());
		}
		
		
		assertEquals(retLocations,varLocations);
		
		//assertTrue(retLocations.size()==3);
		
		
	}
	
}
