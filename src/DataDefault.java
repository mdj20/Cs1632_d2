import java.util.ArrayList;


public class DataDefault {

	static int x = 4;
	static int y = 2;
	
	public static ArrayList<Street> defaultStreetInfo(){
		
		ArrayList<Street> dstr = new ArrayList<Street>();
		
		dstr.add(new Street("Fourth ave",0,0,3,0,1));
		dstr.add(new Street("Fifth ave",0,1,3,1,-1));
		dstr.add(new Street("Meow Street",1,0,1,1,0));
		dstr.add(new Street("Chirp ave",2,0,2,1,0));
		
		return dstr;
	}
	
	
	public static ArrayList<CityLocation> defaultCityLocInfo(){
		
		ArrayList<CityLocation> dloc = new ArrayList<CityLocation>();
		
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
	
	public static boolean addSpawnPoints(CityLayout city, ArrayList<CityLocation> loc){
		
		boolean result = true;
		
		city.addSpawnPoint(0,0);
		city.addSpawnPoint(1,0);
		city.addSpawnPoint(2,0);
		city.addSpawnPoint(1,1);
		city.addSpawnPoint(2,1);
		city.addSpawnPoint(3,1);
		
		return result;
		
	}
	
	
	
}
