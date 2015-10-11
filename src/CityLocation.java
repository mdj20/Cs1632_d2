
public class CityLocation {
	
	private String name;
	private int x;
	private int y;
	private boolean inCity;
	
	
	CityLocation(String inName, int x0, int y0, boolean in){		
		name = inName;
		x = x0;
		y = y0;
		inCity = in;
	}
	
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
