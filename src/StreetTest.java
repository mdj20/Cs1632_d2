import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class StreetTest {
	
	static Street dblstr[];

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//num of iterations
		int itr = 100;
		dblstr = new Street[itr];
		
		for (int i = 0 ; i < itr ; i++){
			
			dblstr[i] = new Street(Integer.toString(i),i,i,i,i,i);
			
			
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testX() {
		
		//num of iterations
		int itr = 100;
		
		//test containers 
		int actual[] = new int[itr];
		int expected[] = new int[itr];
		
		
		// create test values, and retrieve actual
		for (int i = 0 ; i < itr ; i++){
			
			expected[i] = i;
			actual[i] = dblstr[i].x();
			
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testX1() {
		//num of iterations
		int itr = 100;
		
		//test containers 
		int actual[] = new int[itr];
		int expected[] = new int[itr];

		// create test values, and retrieve actual
		for (int i = 0 ; i < itr ; i++){
			
			expected[i] = i;
			actual[i] = dblstr[i].x1();
			
		}
		
		assertArrayEquals(expected,actual);
	}
	

	@Test
	public void testY() {
		//num of iterations
		int itr = 100;
		
		//test containers 
		int actual[] = new int[itr];
		int expected[] = new int[itr];
		

		// create test values, and retrieve actual
		for (int i = 0 ; i < itr ; i++){
			
			expected[i] = i;
			actual[i] = dblstr[i].y();
			
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testY1() {
		
		//num of iterations
		int itr = 100;
		
		//test containers 
		int actual[] = new int[itr];
		int expected[] = new int[itr];
		

		// create test values, and retrieve actual
		for (int i = 0 ; i < itr ; i++){
			
			expected[i] = i;
			actual[i] = dblstr[i].y1();
			
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testFlow() {
		
		//num of iterations
		int itr = 100;
		
		//test containers 
		int actual[] = new int[itr];
		int expected[] = new int[itr];
		

		// create test values, and retrieve actual
		for (int i = 0 ; i < itr ; i++){
			
			expected[i] = i;
			actual[i] = dblstr[i].flow();
			
		}
		
		assertArrayEquals(expected,actual);
	}

	@Test
	public void testName() {
		
		//num of iterations
		int itr = 100;
		
		//test containers 
		String actual[] = new String[itr];
		String expected[] = new String[itr];
		

		// create test values, and retrieve actual
		for (int i = 0 ; i < itr ; i++){
			
			expected[i] = new String(Integer.toString(i));
			actual[i] = dblstr[i].name();
			
		}
		
		assertArrayEquals(expected,actual);
	}

}
