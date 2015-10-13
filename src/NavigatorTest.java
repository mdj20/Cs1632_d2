import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

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

	
	// test will verify that each location will allow for the correct number of possible moves.
	// (move to any spot along streets, driver is currently on)
	@Test
	public void testNumberAllPossibleLocations(){
		
		LinkedHashMap<Street,ArrayList<CityLocation>> retLocations =  Navigator.getAllPossibleLocations( locations.get(7), testCity);
		
		ArrayList<CityLocation> varLocations = new ArrayList<CityLocation>();
		varLocations.add(locations.get(4));
		varLocations.add(locations.get(5));
		varLocations.add(locations.get(6));
		
		System.out.println(retLocations.size());
		for (CityLocation cl : retLocations){
			System.out.println(cl.name()+" "+cl.x()+cl.y());
		}
		
		
		assertEquals(retLocations,varLocations);
		
				
		
	}
	
	// Test will verify that each location will allow for the correct number of possible 
	// moves (one space away). 
	
	@Test
	public void testNumberNextPossibleLocations(){
	
		int testInts[] ={1,2,2,0,0,2,2,1};
		int retVal[] = new int[8];
	
		int index = 0;
	
		for (CityLocation cl : testCity.locationList()){
			
			ArrayList<CityLocation> retLocations =  Navigator.getNextPossibleLocations( cl, testCity);
			retVal[index++] = retLocations.size();
		}
				
		assertArrayEquals(retVal,testInts);
		
	}
}
