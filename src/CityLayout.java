import java.util.ArrayList;


public class CityLayout {
	
	private CityLocation[][] cityMatrix;
	private ArrayList<Street> roads;
	
	
	
	CityLayout(int x, int y, ArrayList<CityLocation> layout, ArrayList<Street> inRoads){
		
		
		cityMatrix = new CityLocation[x][y];
		
		for (CityLocation cl : layout){
			cityMatrix[cl.x()][cl.y()] = cl;
		}
		
		roads = inRoads;
		
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
	
	public CityLocation getLocationAt(int x, int y){
		
		return cityMatrix[x][y];
		
	}
	
}

