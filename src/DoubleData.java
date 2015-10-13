import java.util.ArrayList;


// quick double data

public class DoubleData {


	private static int x = 8; // x dimension 
	private static int y = 1; // y dimension 
	
	// dimension fetch
	public static int x(){ return x; }
	public static int y(){ return y; }
	
	// return default street info
	public static ArrayList<Street> defaultStreetInfo(){
		
		ArrayList<Street> dstr = new ArrayList<Street>();
		dstr.add(new Street("Double Street",0,0,7,0,0));	
		return dstr;
	}
	
	
	// default city location info
	public static ArrayList<CityLocation> defaultCityLocInfo(){
		
		// return container
		ArrayList<CityLocation> dloc = new ArrayList<CityLocation>();
		
		// individual location data
		dloc.add(new CityLocation("Outside",0,0,false));
		dloc.add(new CityLocation("one",1,0,true));
		dloc.add(new CityLocation("two",2,0,true));
		dloc.add(new CityLocation("three",3,0,true));
		dloc.add(new CityLocation("four",4,0,true));
		dloc.add(new CityLocation("five",5,0,true));
		dloc.add(new CityLocation("six",6,0,true));
		dloc.add(new CityLocation("Outside",7,0,false));
		

		
	
		
		return dloc;
	}
	
	// adds spawn point to CityLayout that is passed in
	public static void addSpawnPoints(CityLayout city, ArrayList<CityLocation> loc){
			
		city.addSpawnPoint(3,0);
		city.addSpawnPoint(4,0);
	
		
	}
	
	
	
	
	
	
	
	
}
