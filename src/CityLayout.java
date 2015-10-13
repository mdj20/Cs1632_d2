import java.util.ArrayList;
import java.util.Random;


public class CityLayout {
	
	// building location
	private CityLocation[][] cityMatrix;
	private ArrayList<CityLocation> locationList;
	
	//street info in an edge list
	private ArrayList<Street> roads;
	
	//spawn locations
	private ArrayList<CityLocation> sLoc;
	
	CityLayout(int x, int y, ArrayList<CityLocation> layout, ArrayList<Street> inRoads){
		
		// initialize city grid
		cityMatrix = new CityLocation[x][y];
		
		//initialize spawn points
		sLoc = new ArrayList<CityLocation>();
		
		//initlize new location list
		locationList = new ArrayList<CityLocation>(layout);
		
		//init new road list
		roads = new ArrayList<Street>(inRoads);
		
		// place 
		for (CityLocation cl : locationList){
			cityMatrix[cl.x()][cl.y()] = cl;
		}
		

		
	}
			
	
	public ArrayList<Street> roads(){
		return roads;
	}
	
	// checks if loation exists.
	public boolean locationAt(int x , int y){
		
		
		// null check
		if (cityMatrix[x][y] != null){
			return true;
		}
		else {
			return false;
		}
		
		
	}

	// gets location at
	public CityLocation getLocationAt(int x, int y){
		
		return cityMatrix[x][y];
		
	}
	
	// adds spawn point to city map, returns null if x/y don't describe valid point
	public CityLocation addSpawnPoint(int x, int y){
		
		CityLocation retLocation = null;
		
		// checks for valid location
		if (locationAt(x,y)){
		
			// checks if spawn point isn't set already, and has a valid exit.
			if ( ! sLoc.contains(getLocationAt(x,y)) ){
			
				sLoc.add(getLocationAt(x,y));
				
				retLocation = getLocationAt(x,y);
				
			}
		
		}
		
		return retLocation;
	}
	
	// returns random spawn point/ requires Random
	public CityLocation getRandomSpawnPoint(Random r){
		
		return sLoc.get(r.nextInt(sLoc.size()));
		
	}
	
	// number of spawn points (used for random value choosing )
	public int getNumSpawnPoints(){
		return sLoc.size();
	}
	
	// gets spawn points 
	public ArrayList<CityLocation> spawnPoints(){
		return sLoc;
	}
	
	// gets ArrayList<CityLocation> of locations
	public ArrayList<CityLocation> locationList(){
		return locationList;
	}
	
}

