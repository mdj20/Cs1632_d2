import java.util.ArrayList;


// This class will house the location searching algorithm


public class Navigator {

	//
	public static ArrayList<CityLocation> getPossibleLocation(CityLocation initial, City city){
		
		// allocate return locations
		ArrayList<CityLocation> returnLocations = new ArrayList<CityLocation>();
		
		// list of roads that intersect current location
		ArrayList<Street> onRoads = roadsAtIntersection(initial.x(),initial.y(),city);
		
		for (Street s : onRoads){
		
			
			
		}
		
		
		
		
		return returnLocations;
		
		
	}
	
	//returns list of roads available at the provided location
	private static ArrayList<Street> roadsAtIntersection(int x, int y, City city){
		
		ArrayList<Street> retStreets = new ArrayList<Street>();
		for (Street s : city.roads()){
	
			// Street is NorthSouth bound and intersection falls on same longitude 
			if ( s.x() == s.x1() && x == s.x()){
				
				// if intersection falls within street range
				if (y >= s.y()  && y <= s.y1()){
					retStreets.add(s);
				}
				
			}
			
			//  Street is East West bound and intersection falls on same latitude
			else if (s.y() == s.y1() && y == s.y() ){
				
				// if intersection falls within street range
				if ( x >= s.x()  && x <= s.x1()){
					retStreets.add(s);
				}
				
				
			}
			
			
		}
		
		return retStreets;
		
		
	}
	
	
	private static ArrayList<CityLocation> getPossibleLocations(CityLocation location, ArrayList<Street> roads){
		
		// final returned list of possible locations
		ArrayList<CityLocation> retLocarions = new ArrayList<CityLocation>();
		
		
		// 
		for (Street s : roads){
			
		if (s.x() == s.x1()){
			
			if(s.flow())
			
			
			
			
			
			
			
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
