import java.util.ArrayList;
import java.util.Random;


public class Cs1632_d2 {

	public static void main(String args[]){
		
		long dseed = System.nanoTime();
		
		ArrayList<CityLocation> locations = DataDefault.defaultCityLocInfo();
		ArrayList<Street> streets = DataDefault.defaultStreetInfo();
		Random r = new Random(dseed);
		CityLayout city = new CityLayout(4,2,locations,streets);
		
		
		
		
		
		System.out.println("ret:"+Navigator.getPossibleLocation(city.getLocationAt(0, 0), city).size());
	
		/*
		Driver d0 = new Driver(0,city,city.getRandomSpawnPpoint(r));
		Driver d1 = new Driver(1,city,city.getRandomSpawnPpoint(r));
		Driver d2 = new Driver(2,city,city.getRandomSpawnPpoint(r));
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(d0);
		drivers.add(d1);
		drivers.add(d2);
		
		
		boolean running = true;
		
		while (running){
			
			for(Driver d : drivers){
				
				if (! d.isFinished())
					d.moveRandom(r);
		
				}
			
			running = false;
			
			for(Driver d : drivers ){
				
				running = ! d.isFinished() || running;
		
			}
			
			
			
		}
		
		*/
		
	}
	

	

	

	
}
