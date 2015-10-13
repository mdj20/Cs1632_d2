import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;

public class Driver {
	
	private int num;  // Driver number ID
	private CityLocation current;  // location of driver 
	private boolean finished; // driver is finished 
	private CityLayout city;  /// city info pointer 
	private ArrayList<HistoryEntry> driverHistory;  // driver history
	
	// constructor
	Driver(int inNum, CityLayout inCity, CityLocation initialLocation){	
		
		city = inCity;
		num = inNum;
		finished = false;
		current = initialLocation;
		driverHistory = new ArrayList<HistoryEntry>();
	}
	
	// moves to specific location
	public CityLocation move(CityLocation dest, Street via){
		
		if(!finished){
			driverHistory.add(new HistoryEntry(this,current,via,dest,new Date()));
			this.current = dest;
			
		}
		checkAndSetFinished();
		return this.current;
	}
	
	//moves the driver one spot away 
	public CityLocation moveOneRand(Random r){
		
		if (!finished){
			LinkedHashMap<Street, ArrayList<CityLocation>> roadsAndLocations = Navigator.getNextPossibleLocations(current, city);
		
			ArrayList<Street> keys = new ArrayList<Street>(roadsAndLocations.keySet());
		
			Street via = keys.get(r.nextInt(keys.size()));
			ArrayList<CityLocation> locations = roadsAndLocations.get(via);
	
			CityLocation dest = locations.get(r.nextInt(locations.size()));
		
			return move(dest,via);
		}
		else{
			return current;
		}
		
	}
		
	// driver moves to any available spot on current streets
	public CityLocation moveRandom(Random r ){
		
		if (!finished){
			
			LinkedHashMap<Street, ArrayList<CityLocation>> roadsAndLocations = Navigator.getAllPossibleLocations(current, city);
			
			ArrayList<Street> keys = new ArrayList<Street>(roadsAndLocations.keySet());
			
			Street via = keys.get(r.nextInt(keys.size()));
			ArrayList<CityLocation> locations = roadsAndLocations.get(via);
			
			CityLocation dest = locations.get(r.nextInt(locations.size()));

			return move(dest,via);
			
		}
		else{
			return current;
		}
	}
	
	// public method
	public ArrayList<HistoryEntry> getDriverHistory(){
		return driverHistory;
	}
	
	// if current location is not in the city then will set finished to true. This should not be called unless after a successful move.  
	private void checkAndSetFinished(){
		finished = finished || ! current.inCity() ;
	}
	
	// public method
	public boolean isFinished(){
		return finished;
	}
	
	// public method
	public int getNumber(){
		return num;
	}
	
	// public method
	public CityLocation current(){
		return current;
	}
	
}
