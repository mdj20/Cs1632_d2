
/*
 * CLass stores location data
 */

public class CityLocation {
	
	private String name;  // name 
	private int x;  // x location
	private int y; // y location 
	private boolean inCity; // is it in city or outise?
	
	
	// constructor
	CityLocation(String inName, int x0, int y0, boolean in){		
		name = inName;
		x = x0;
		y = y0;
		inCity = in;
	}
	
	// public methods
	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	
	public String name(){
		return name;
	}

	
	public boolean inCity(){
		return inCity;
	}
	
}
