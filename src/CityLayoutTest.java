import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;


public class CityLayoutTest {
	
	
	// data required
	static CityLayout testCity;
	static ArrayList<CityLocation> locations;
	static ArrayList<Street> streets; 
	static Random testR;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		// set up data
		locations = DataDefault.defaultCityLocInfo();
		streets = DataDefault.defaultStreetInfo();		
		testCity = new CityLayout(DataDefault.x(),DataDefault.y(),locations,streets);
		testR = new Random(System.nanoTime());
		DataDefault.addSpawnPoints(testCity, locations);
	}


	
	//custom test
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
	
	
	@Test
	public void testGetRandomSpawnPoint(){
		
		ArrayList<CityLocation> expected = new ArrayList<CityLocation>();
		
		expected = testCity.spawnPoints();
		
		boolean missed = false;
		
		for (int i = 0 ; i <100 ; i ++){
			missed = missed || !(expected.contains(testCity.getRandomSpawnPoint(testR)));
		}
		
		assertTrue(!missed);
		
	}
	
}
