
public class Street {

	// Street name
	private String name;
	
	// Directions legal to drive;
	private int flow;	// 0 = twoWay ,  < 0 negative direction (north or west ) ; >0 positive Direction (south or east)
	
	// vertex coordinates 
	private int x,x1,y,y1;

	Street(String inName, int xStart, int yStart, int xEnd , int yEnd , int flow ){
		
		name = inName;
		x= xStart;
		y = yStart;
		x1 = xEnd;
		y1 = yEnd;
	}
	
	public int x(){
		return x;
	}
	
	public int x1(){
		return x1;
	}
	
	public int y(){
		return y;
	}
	
	public int y1(){
		return y1;
	}
	
	public int flow(){
		return flow;
	}


	
		
}
