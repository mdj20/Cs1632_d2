import java.util.ArrayList;
import java.util.Random;


public class Cs1632_d2 {

	public static void main(String args[]){
		
		long dseed = System.nanoTime();
		
		ArrayList<CityLocation> locations = DataDefault.defaultCityLocInfo();
		ArrayList<Street> streets = DataDefault.defaultStreetInfo();
		Random r = new Random(dseed);
		CityLayout city = new CityLayout(4,2,locations,streets);
		
		
		
		
		
		System.out.println("ret:"+Navigator.getAllPossibleLocations(city.getLocationAt(0, 0), city).size());
	
		DataDefault.addSpawnPoints(city, locations);
		
		
		
		Driver d0 = new Driver(0,city,city.getRandomSpawnPoint(r));
		Driver d1 = new Driver(1,city,city.getRandomSpawnPoint(r));
		Driver d2 = new Driver(2,city,city.getRandomSpawnPoint(r));
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(d0);
		drivers.add(d1);
		drivers.add(d2);
		
		
		boolean running = true;
		
		while (running){
			
			for(Driver d : drivers){
				
				if (! d.isFinished())
					d.moveOneRand(r);
				}
			
			running = false;
			
			for(Driver d : drivers ){
				
				running = ! d.isFinished() || running;
		
		}
			
			
		for(Driver d : drivers){
			
			ArrayList<HistoryEntry> entry = d.getDriverHistory();
			
			System.out.println(entry.size());
			
			for(HistoryEntry he: entry){
				System.out.println(he.driver().getNumber()+" "+he.destination().name()+" "+he.street().name());
			}
			
			
		}
		
			
			
		}// end Main	
	} // end class
	

	

	

	
}
