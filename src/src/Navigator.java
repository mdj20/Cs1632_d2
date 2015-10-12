import java.util.ArrayList;


// This class will house the location searching algorithm


public class Navigator {

	//
	public static ArrayList<CityLocation> getPossibleLocation(CityLocation initial, CityLayout city){
		
		// allocate return locations
		ArrayList<CityLocation> returnLocations = new ArrayList<CityLocation>();
		
		// list of roads that intersect current location
		ArrayList<Street> onRoads = roadsAtIntersection(initial.x(),initial.y(),city);
		
		
		
		for (Street s : onRoads){
		
			//System.out.println("st name :" + s.name() );
			
			returnLocations.addAll(getLocationsOnRoad(initial,s,city));
			
		}
		
		return returnLocations;
		
		
	}
	
	//returns list of roads available at the provided location
	private static ArrayList<Street> roadsAtIntersection(int x, int y, CityLayout city){
		
		ArrayList<Street> retStreets = new ArrayList<Street>();
		
		
		for (Street s : city.roads()){
			

			// Street is NorthSouth bound and intersection falls on same longitude 
			if ( (s.x() == s.x1()) && ( s.x() == x ) ){
				
				
				
				// if intersection falls within street range
				if ( ( y >= s.y() ) && ( y  <= s.y1() )){
					retStreets.add(s);
					
					
				}
				
			}
			
			//  Street is East West bound and intersection falls on same latitude
			else if (( s.y() == s.y1() ) && ( y == s.y() ) ){
				
				
				// if intersection falls within street range
				if (( x >= s.x() )  && ( x <= s.x1() ) ){
					retStreets.add(s);
					
				}
				
				
			}
			
			
		}
		
		return retStreets;
		
		
	}
	
	// method returns ArrayList of CityLocation(s) that will describe the possible moves a driver can make
	// NOTE: this will return all locations on the road(s) that the driver is currently one, regardless of distance on particular road.
	private static ArrayList<CityLocation> getLocationsOnRoad(CityLocation location, Street road, CityLayout city){
		
		// final returned list of possible locations
		ArrayList<CityLocation> retLocations = new ArrayList<CityLocation>();
		
		
		
		// Street is NorthSouth
		if ( road.x() == road.x1() ){
			
			// Negative one way or bidirectional
			if ( road.flow() <= 0  ){
			
				// Iterate down road and collect possible destinations 
				for (int i = road.y() ; i < location.y() ; i++ ){
					
					if(city.locationAt(road.x(), i)){
						retLocations.add(city.getLocationAt(road.x(), i));
					}
					
				}
					
			
			}

			// Positive one way or bidirectional
			if ( road.flow() >= 0  ){
			
				// iterate down road and collect possible destinations 
				for (int i = location.y()+1 ; i <= road.y1() ; i++ ){
					
					if(city.locationAt(road.x(), i)){
						retLocations.add(city.getLocationAt(road.x(), i));
					}
					
				}
				
				
				
			}	
		}
		else if (road.y() == road.y1()){
			
			if ( road.flow() <= 0  ){
				
				// Iterate down road and collect possible destinations 
				for (int i = road.x() ; i < location.x() ; i++ ){
					
					if(city.locationAt(i, road.y())){
						retLocations.add(city.getLocationAt(i, road.y()));
					}
					
				}
					
			
			}

			// Positive one way or bidirectional
			if ( road.flow() >= 0  ){
			
				// iterate down road and collect possible destinations 
				for (int i = location.x()+1 ; i <= road.x1() ; i++ ){
					
					if(city.locationAt(i, road.y())){
						retLocations.add(city.getLocationAt(i, road.y()));
					}
					
				}
				
				
				
			}	
							
		}				
			
		return retLocations;
	
	}
}
