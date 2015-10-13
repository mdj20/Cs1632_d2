import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class HistoryEntryTest {

	static HistoryEntry dblData[];
	static int itr = 100;
	static Driver  tDriver;
	static CityLayout tCity;
	static ArrayList<CityLocation> locations;
	static ArrayList<Street> streets; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dblData = new HistoryEntry[itr];
		
		locations = DoubleData.defaultCityLocInfo();
		streets = DoubleData.defaultStreetInfo();		
		
		
		tCity = new CityLayout(DoubleData.x(),DoubleData.y(),locations,streets);
		tDriver = new Driver(0,tCity,locations.get(1));
		int j = 0;
		int k = 0;
		
		for (int i = 0 ; i < itr ; i ++){

			if (j == locations.size()){
				j = 0;
			}
			
			if (k == streets.size()){
				k = 0;
			}
			
			
	         dblData[i] = new HistoryEntry(tDriver,locations.get(j),streets.get(k++),locations.get(j++),new Date(i));
			
		}
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testDriver() {


		Driver expected[] = new Driver[itr];
		Driver actual[] = new Driver[itr];
		
		for(int i = 0 ; i < itr ; i ++){
			expected[i] = tDriver;
			actual[i] = dblData[i].driver();
		}
		
		assertArrayEquals(expected,actual);
		
	}

	@Test
	public void testStreet() {
		Street expected[] = new Street[itr];
		Street actual[] = new Street[itr];
		
		int k = 0 ;
		
		for(int i = 0 ; i < itr ; i ++){
			
			if (k == streets.size()){
				k = 0;
			}
			
			expected[i] =  streets.get(k++);
			actual[i] = dblData[i].street();
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testDestination() {
		CityLocation expected[] = new CityLocation[itr];
		CityLocation actual[] = new CityLocation[itr];
		
		int k = 0 ;
		
		for(int i = 0 ; i < itr ; i ++){
			
			if (k == locations.size()){
				k = 0;
			}
			
			expected[i] =  locations.get(k++);
			actual[i] = dblData[i].destination();
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testDate() {
		Date expected[] = new Date[itr];
		Date actual[] = new Date[itr];
		
		int k = 0 ;
		
		for(int i = 0 ; i < itr ; i ++){
		
			
			expected[i] =  new Date(i);
			actual[i] = dblData[i].date();
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testLeaving() {
		CityLocation expected[] = new CityLocation[itr];
		CityLocation actual[] = new CityLocation[itr];
		
		int k = 0 ;
		
		for(int i = 0 ; i < itr ; i ++){
			
			if (k == locations.size()){
				k = 0;
			}
			
			expected[i] =  locations.get(k++);
			actual[i] = dblData[i].leaving();
		}
		
		assertArrayEquals(expected,actual);
	}

}
