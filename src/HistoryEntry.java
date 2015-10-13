import java.util.Date;
/*
 * Contains data for driver history
 * 
 */

public class HistoryEntry {
	
	private Driver driver;  // driver
	private CityLocation leaving; // leaving locations
	private Street street; // via street 
	private CityLocation destination; // destination location
	Date date; // time etc
	
	// Constructor 
	HistoryEntry(Driver d, CityLocation source, Street s, CityLocation sink, Date dt){
		driver = d;
		leaving = source;
		street = s; 
		destination = sink;
		date = dt;
	}
	
	
	// public methods below
	public Driver driver(){
		return driver;
	}
	
	public Street street(){
		return street;
	}
	
	public CityLocation destination(){
		return destination;
	}
	
	public Date date(){
		return date;
	}
	
	public CityLocation leaving(){
		return leaving;
	}

}
