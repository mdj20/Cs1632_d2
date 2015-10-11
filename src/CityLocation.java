
public class CityLocation {
	
	private String name;
	private int x;
	private int y;
	
	
	CityLocation(String inName, int x0, int y0){		
		name = inName;
		x = x0;
		y = y0;
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

	
	
	
}
