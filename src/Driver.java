import java.util.ArrayList;
import java.util.Random;


public class Driver {
	
	private int num;
	private CityLocation current;
	boolean started;
	City city;
	ArrayList<CityLocation> driverHistory;
	
	
	Driver(int inNum, City inCity, CityLocation initialLocation){
		
		inCity = city;
		num = inNum;
		started = false;
		current = initialLocation;
		driverHistory = new ArrayList<CityLocation>();
	}
	
	public void move(CityLocation nextLocation){
		
	}
	
	//moves the driver one spot away 
	public void moveOneRand(Random r){
		
	}
	
	// driver moves to any avalible spot on current streets
	public void moveRandom(Random r ){
		
	}
}
