import java.util.ArrayList;
import java.util.Random;


public class Cs1632_d2 {

	public static void main(String args[]){
		
		long dseed = System.nanoTime();
		
		ArrayList<CityLocation> locations = DataDefault.defaultCityLocInfo();
		ArrayList<Street> streets = DataDefault.defaultStreetInfo();
		Random r = new Random(dseed);
		CityLayout city = new CityLayout(4,2,locations,streets);
		
		
		
		DataDefault.addSpawnPoints(city, locations);
		
		
		

		ArrayList<Driver> drivers = new ArrayList<Driver>();
		
		for (int i = 0 ; i < 50 ; i++){
			 drivers.add(new Driver(i,city,city.getRandomSpawnPoint(r)));
		}
		
		


		
		
		boolean running = true;
		
		while (running){
			
			for(Driver d : drivers){
				
				if (! d.isFinished()){
					d.moveOneRand(r);
				}
			}
			
			running = false;
			for(Driver d : drivers ){
				
				running = ! d.isFinished() || running;
				
		
			}
			
			
		}
		for(Driver d : drivers){
			
			System.out.println();
			
			DataDefault.printHistory(d);
			
			
		}
		
			
			
		}// end Main	
	} // end class
	

	

	

	

