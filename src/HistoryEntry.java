import java.util.Date;


public class HistoryEntry {
	
	private Driver driver;
	private CityLocation leaving;
	private Street street;
	private CityLocation destination;
	Date date;
	
	
	HistoryEntry(Driver d, CityLocation source, Street s, CityLocation sink, Date dt){
		driver = d;
		leaving = source;
		street = s; 
		destination = sink;
		date = dt;
	}
	
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
