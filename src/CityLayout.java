import java.util.ArrayList;
import java.util.Random;


public class CityLayout {
	
	// building location
	private CityLocation[][] cityMatrix;
	
	//street info in an edge list
	private ArrayList<Street> roads;
	
	//spawn locations
	public ArrayList<CityLocation> sLoc;
	
	CityLayout(int x, int y, ArrayList<CityLocation> layout, ArrayList<Street> inRoads){
		
		
		cityMatrix = new CityLocation[x][y];
		sLoc = new ArrayList<CityLocation>();
		
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
	
	public boolean addSpawnPoint(int x, int y){
		
		boolean result = false;
		
		// checks for valid location
		if (locationAt(x,y)){
		
			// checks if spawn point isn't set already, and has a valid exit.
			if ( ! sLoc.contains(getLocationAt(x,y)) && ( Navigator.getPossibleLocation( getLocationAt(x, y), this ).size() >0 )   ){
			
				sLoc.add(getLocationAt(x,y));
				result = true;
			
			}
		
		}
		
		return result;
	}
	
	// returns random spawn point/ requires Random
	public CityLocation getRandomSpawnPpoint(Random r){
		
		return sLoc.get(r.nextInt(sLoc.size()));
		
	}
	
	public int getNumSpawnPoints(){
		return sLoc.size();
	}
	
}

