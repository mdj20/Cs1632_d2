import java.util.ArrayList;

/* DataDefault.class acts as a initial data store and utility class for the program.
 * 
 * This simulates the game data files, not included in this build.
 *
 * 
 *  */

public class DataDefault {

	private static int x = 4; // x dimension 
	private static int y = 2; // y dimension 
	
	// dimension fetch
	public static int x(){ return x; }
	public static int y(){ return y; }
	
	// return default street info
	public static ArrayList<Street> defaultStreetInfo(){
		
		ArrayList<Street> dstr = new ArrayList<Street>();
		dstr.add(new Street("Fourth ave",0,0,3,0,1));
		dstr.add(new Street("Fifth ave",0,1,3,1,-1));
		dstr.add(new Street("Meow Street",1,0,1,1,0));
		dstr.add(new Street("Chirp ave",2,0,2,1,0));
		
		return dstr;
	}
	
	
	// default city location info
	public static ArrayList<CityLocation> defaultCityLocInfo(){
		
		// return container
		ArrayList<CityLocation> dloc = new ArrayList<CityLocation>();
		
		// individual location data
		dloc.add(new CityLocation("Outside of City",0,0,false));
		dloc.add(new CityLocation("Mall",1,0,true));
		dloc.add(new CityLocation("Bookstore",2,0,true));
		dloc.add(new CityLocation("Outside of City",3,0,false));
		dloc.add(new CityLocation("Outside of City",0,1,false));
		dloc.add(new CityLocation("Coffee",1,1,true));
		dloc.add(new CityLocation("University",2,1,true));
		dloc.add(new CityLocation("Outside of City",3,1,false));	
		
		return dloc;
	}
	
	// adds spawn point to CityLayout that is passed in
	public static void addSpawnPoints(CityLayout city, ArrayList<CityLocation> loc){
			
		city.addSpawnPoint(0,0);
		city.addSpawnPoint(1,0);
		city.addSpawnPoint(2,0);
		city.addSpawnPoint(1,1);
		city.addSpawnPoint(2,1);
		city.addSpawnPoint(3,1);
		
	}
	

	// driver print utility
	public static void printHistory(Driver d){
		
		// get history entries from driver
		ArrayList<HistoryEntry> history = d.getDriverHistory();
		
		// print each history out in format following example output
		for (HistoryEntry h : history){
			
			System.out.println("Driver "+h.driver().getNumber()+" heading from "+h.leaving().name()
					+" to "+h.destination().name()+" via "+h.street().name()+" @ "+h.date());
			
		}
		
		
		
	}
	
	
	
}
