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
		testCity = new CityLayout(DataDefault.x(),DataDefault.y(),locations,streets);	
		DataDefault.addSpawnPoints(testCity, locations);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
	// test will verify that each location will allow for the correct number of possible moves.
	// (move to any spot along streets, driver is currently on)
	@Test
	public void testNumberAllPossibleLocations(){
		
		int expected[] = {3,3,2,0,0,2,3,3};
		int actual[] = new int[expected.length];
		
		int index = 0;
		
		for(CityLocation cl : locations){
			
			LinkedHashMap<Street,ArrayList<CityLocation>> retLocations =  Navigator.getAllPossibleLocations( cl , testCity);
		
			ArrayList<CityLocation> varLocations = new ArrayList<CityLocation>();
				
			for (Street s : retLocations.keySet()){
			
					varLocations.addAll(retLocations.get(s));
			}
			
			actual[index++] = varLocations.size();
		}
		
		assertArrayEquals(expected,actual);
		
				
		
	}
	
	// Test will verify that each location will allow for the correct number of possible 
	// moves (one space away). 
	
	@Test
	public void testNumberNextPossibleLocations(){
	
		int expected[] ={1,2,2,0,0,2,2,1};
		int actual[] = new int[8];
	
		int index = 0;
	
		for (CityLocation cl : testCity.locationList()){
			
			// locations in 
			LinkedHashMap<Street,ArrayList<CityLocation>> retLocations =  Navigator.getNextPossibleLocations(cl, testCity);
			
			int temp = 0;
			
			for (Street s : retLocations.keySet()){
			
				temp += retLocations.get(s).size();
			}
			
			actual[index++] = temp;
		}
				
		assertArrayEquals(expected,actual);
		
	}
}
