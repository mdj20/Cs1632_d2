import java.util.ArrayList;


public class City {
	
	private CityLocation[][] cityMatrix;
	private ArrayList<Street> roads;
	
	
	
	City(int x, int y, ArrayList<String> layout, ArrayList<Street> inRoads){
		
		
		cityMatrix = new CityLocation[x][y];
		String tempLoc = layout.get(0);
		roads = inRoads;
		
		for(int i = 0 ; i < x ; i++ ){
		
			for(int j = 0 ; j < y ; j++ ){
			cityMatrix[x][y] = new CityLocation(tempLoc,i,j);
				
			}
		}
		
	}
	
	public ArrayList<CityLocation> getPossibleLocations(CityLocation inLoc){
	
		ArrayList possible = new ArrayList<CityLocation>();
		
		
		
		ArrayList mockLocation = new ArrayList<CityLocation>();
		mockLocation.add(new CityLocation("MOCK LOCATION", 0 , 0));
		return  mockLocation;
		
	}
	
	public ArrayList<Street> roads(){
		return roads;
	}
	
	public boolean locationAt(int x , int y){
		
		if (cityMatrix[x][y] != null){
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
}

