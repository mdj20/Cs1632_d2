import java.util.ArrayList;
import java.util.Random;


public class Driver {
	
	private int num;
	private CityLocation current;
	private boolean finished;
	private CityLayout city;
	private ArrayList<CityLocation> driverHistory;
	
	
	Driver(int inNum, CityLayout inCity, CityLocation initialLocation){
		
		city = inCity;
		num = inNum;
		finished = false;
		current = initialLocation;
		driverHistory = new ArrayList<CityLocation>();
	}
	
	// moves to specific location
	public CityLocation move(CityLocation nextLocation){
		
		if(!finished){
			
			driverHistory.add(current);
			
			current= nextLocation;
		}
		
		
		checkAndSetFinished();
		return current;
	}
	
	//moves the driver one spot away 
	public CityLocation moveOneRand(Random r){
		
		if (!finished){
			
			
				
			driverHistory.add(current);
			
			
			
			
		}
		
		checkAndSetFinished();
		return current;
	}
	
	// driver moves to any avalible spot on current streets
	public CityLocation moveRandom(Random r ){
		
		if (!finished){
			
			ArrayList<CityLocation> pLocations = Navigator.getPossibleLocation(current, city);
			
			int index = r.nextInt(pLocations.size());
			
			move(pLocations.get(index));
			
			
		}
		
		checkAndSetFinished();
		return current;
	}
	
	public ArrayList<CityLocation> getDriverHistory(){
		return driverHistory;
	}
	
	// if current location is not in the city then will set finished to true. This should not be called unless after a successful move.  
	private void checkAndSetFinished(){
		finished = finished || ! current.inCity() ;
	}
	
	public boolean isFinished(){
		return finished;
	}
	
	public int getNumber(){
		return num;
	}
}
