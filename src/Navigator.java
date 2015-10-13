import java.util.ArrayList;
import java.util.LinkedHashMap;


// This class will house the location searching algorithm


public class Navigator {

	// Method returns LinkedHashMap<Street,ArrayList<CityLocation>> that contains all of the possible locations a driver may travel, 
	// on the street(s) that s/he is on. This meens that a driver may choose to move any number of spaces away as long as s/he is 
	// does not change roads. (Not implemented in final product)
	public static LinkedHashMap<Street,ArrayList<CityLocation>> getAllPossibleLocations(CityLocation initial, CityLayout city){
		
		// return value container
		LinkedHashMap<Street,ArrayList<CityLocation>> returnLocations = new LinkedHashMap<Street,ArrayList<CityLocation>>();
		
		// list of roads that intersect current location
		ArrayList<Street> onRoads = roadsAtIntersection(initial.x(),initial.y(),city);
		
		
		// for all roads on street
		for (Street s : onRoads){
		
			// get all locations on road
			ArrayList<CityLocation> temp = getAllLocationsOnRoad(initial,s,city);
			
			// if any locations, place in container
			if (temp.size() > 0){
				returnLocations.put(s, temp);
			}
			
		}
		
		return returnLocations;
	}
	
	// Method returns LinkedHashMap<Street,ArrayList<CityLocation>> that contains all of the possible locations a driver may travel one space away, 
	// on the street(s) that s/he is on. 
	public static LinkedHashMap<Street,ArrayList<CityLocation>> getNextPossibleLocations(CityLocation initial, CityLayout city){
		
		// return value container
		LinkedHashMap<Street,ArrayList<CityLocation> > returnLocations = new LinkedHashMap<Street,ArrayList<CityLocation> >();
		
		// list of roads that intersect current location
		ArrayList<Street> onRoads = roadsAtIntersection(initial.x(),initial.y(),city); 
		
		// for all roads on street
		for (Street s : onRoads){
			
			//get locations if any
			ArrayList<CityLocation> temp = getNextLocationsOnRoad(initial,s,city);
			
			// if any locations, place in container
			if (temp.size() > 0){
				returnLocations.put(s, temp);
			}
			
		}
		
		return returnLocations;
	}
	
	
	//returns list of roads available at the provided location
	private static ArrayList<Street> roadsAtIntersection(int x, int y, CityLayout city){
		
		// return structure
		ArrayList<Street> retStreets = new ArrayList<Street>();
		
		// checks all roads
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
	private static ArrayList<CityLocation> getAllLocationsOnRoad(CityLocation location, Street road, CityLayout city){
		
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
		
		// road is 
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
	
	//method returns ArrayList of CityLocation(s) that will describe the possible moves a driver can make, one space away
	private static ArrayList<CityLocation> getNextLocationsOnRoad(CityLocation location,Street road, CityLayout city){
		
		// return sructure
		ArrayList<CityLocation> retLocations = new ArrayList<CityLocation>();
		
		// if north/south 
		if(road.x() == road.x1()  && location.x() == road.x()){
			
			// negative direction
			if(road.flow() <= 0 && road.y() < location.y()){
				
				//staring index one less
				int index = location.y()-1;
				
				
				// Iterate until base is reached 
				while (! city.locationAt(road.x(), index) && index >= road.y() ){
					
					index--;
				}
				
				// if road fits criteria, add to return container
				if (city.locationAt(road.x(), index)){
					retLocations.add(city.getLocationAt(road.x(), index));
				}
				
			}	
				
		
			// posative direction 
			if (road.flow() >= 0 && road.y1() > location.y()){

				//staring index one more
				int index = location.y()+1;
				
				// Iterate until limit is reached 
				while (! city.locationAt(road.x(), index) && index <= road.y1() ){
					
					index++;
				}

				// if road fits criteria, add to return container
				if (city.locationAt(road.x(), index)){
					retLocations.add(city.getLocationAt(road.x(), index));
				}
				
				
				
			}
		
		}
		// road is east west	
		else if(road.y() == road.y1()  && location.y() == road.y()){
				
				// negative direction
			if(road.flow() <= 0 && road.x() < location.x()){

				//staring index one less
				int index = location.x()-1;
				
				// Iterate until limit is reached 
				while (! city.locationAt(index, road.y()) && index >= road.x() ){
						
					index--;
				}

				// if road fits criteria, add to return container
				if (city.locationAt(index, road.y())){
					retLocations.add(city.getLocationAt(index,road.y()));
				}
					
					
					
			}
			// 
			if (road.flow() >= 0 && road.x1() > location.x()){

				//staring index one more
				int index = location.x()+1;
					
				// Iterate until limit is reached 
				while (! city.locationAt(index,road.y()) && index <= road.x1() ){
						
					index++;
				}

				// if road fits criteria, add to return container
				if (city.locationAt(index,road.y())){
					retLocations.add(city.getLocationAt(index,road.y()));
				}
							
			}
							
		} // end east west search
		
		return retLocations;
		
	
	}
	
}
