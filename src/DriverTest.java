import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class DriverTest {

	static CityLayout testCity;
	static ArrayList<CityLocation> testLocations;
	static ArrayList<Street> testStreets; 
	static Driver testDriver;
	static Random testR;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		testLocations = DataDefault.defaultCityLocInfo();
		testStreets = DataDefault.defaultStreetInfo();		
		testCity = new CityLayout(DataDefault.x(),DataDefault.y(),testLocations,testStreets);	
		DataDefault.addSpawnPoints(testCity, testLocations);
		
		testR = new Random(System.nanoTime());
		
		testDriver = new Driver(1,testCity,testCity.getRandomSpawnPoint(testR));
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	
	@Test
	public void testMove(){
		
		//temp value for test
		
		CityLocation tempDest = testDriver.current();
		Street tempStr;
		
		//get list of locations that are inside city
		ArrayList<CityLocation> destinations = new ArrayList<CityLocation>();
		ArrayList<Street> streets = new ArrayList<Street>(testStreets);
		
		
		// pull out locations that are in the city (outside city will lock driver)
		for (CityLocation cl : testLocations){
		
			if (cl.inCity()){
				destinations.add(cl);
			}
			
		}
		
				
		// record collections
		ArrayList<CityLocation> expected = new ArrayList<CityLocation>();
		ArrayList<CityLocation> actual = new ArrayList<CityLocation>();
		
		for (int i = 0 ; i < 100 ; i++){
			
			tempDest = destinations.get(testR.nextInt(destinations.size()));
			tempStr = streets.get(testR.nextInt(streets.size()));
			expected.add(tempDest);
			testDriver.move(tempDest,tempStr);
		
			actual.add(testDriver.current());
		}
		
		assertArrayEquals(expected.toArray(),actual.toArray());
		
		
	}

}
