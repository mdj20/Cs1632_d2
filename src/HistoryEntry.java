import java.util.Date;


public class HistoryEntry {
	
	private Driver driver;
	private Street street;
	private CityLocation destination;
	Date date;
	
	
	HistoryEntry(Driver d, Street s, CityLocation cl, Date dt){
		driver = d;
		street = s; 
		destination = cl;
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

}
