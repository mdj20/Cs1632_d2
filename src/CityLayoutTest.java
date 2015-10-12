import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class CityLayoutTest {
	
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
	
	@Test
	public void testMatrixAcuracy() {
		
		ArrayList<CityLocation> expected = new ArrayList<CityLocation>();;
		ArrayList<CityLocation> actual = new ArrayList<CityLocation>();
		
		for (CityLocation cl : locations){
			
			expected.add(cl);
			actual.add(testCity.getLocationAt(cl.x(), cl.y()));
		}
		
		assertArrayEquals(expected.toArray(),actual.toArray());
	
	}
	
	
	@Test 
	public void testRoads(){
		
		ArrayList<Street> expected = new ArrayList<Street>();
		ArrayList<Street> actual = new ArrayList<Street>();
		
		expected.addAll(streets);
		actual.addAll(testCity.roads());
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
	}
	
	@Test 
	public void testLocationList(){
		
		ArrayList<CityLocation> expected = new ArrayList<CityLocation>();
		ArrayList<CityLocation> actual = new ArrayList<CityLocation>();
		
		expected.addAll(locations);
		actual.addAll(testCity.locationList());
		
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
	}
	
}