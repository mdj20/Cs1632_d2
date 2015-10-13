import java.util.ArrayList;
import java.util.Random;


public class Cs1632_d2 {
	
	// main program

	public static void main(String args[]){
		
		// args check
		if (args.length != 1){
			System.out.println("\nPlease enter number for random seed....\n");
			System.exit(0);
		}
		
		//create long for seed
		long dseed = (new Long(args[0]));
		
		// get default data
		ArrayList<CityLocation> locations = DataDefault.defaultCityLocInfo();
		ArrayList<Street> streets = DataDefault.defaultStreetInfo();
		
		// create universal Random
		Random r = new Random(dseed);
		
		// create city
		CityLayout city = new CityLayout(4,2,locations,streets);
	
		// add spawn points
		DataDefault.addSpawnPoints(city, locations);
	
		// Driver List
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		
		// add drivers to list
		for (int i = 0 ; i < 4 ; i++){
			 drivers.add(new Driver(i,city,city.getRandomSpawnPoint(r)));
		}
		
	
		// while drivers are working, switch.
		boolean running = true;
		
		// while drivers are working.
		while (running){
			
			// for each driver
			for(Driver d : drivers){
				
				// if not finished move onece
				if (! d.isFinished()){
					d.moveOneRand(r);
				}
			}
			
			// dset toggle
			running = false;
			
			// if any driver is still running set to true
			for(Driver d : drivers ){
				
				
				// driver logic
				running = ! d.isFinished() || running;
				
		
			}
			
			
		}
		
		// tally results
		for(Driver d : drivers){
			
			System.out.println();
			
			DataDefault.printHistory(d);
			
			
		}
		
			
			
		}// end Main	
	} // end class
	

	

	

	

