import org.junit.*;
import static org.junit.Assert.*;


public class CellTest {

	@Test
	public void testCell_1()
		throws Exception {
		char Alive = '*';
		char Dead = '.';

		Cell result = new Cell(Alive, Dead);

		assertNotNull(result);
		assertEquals('.', result.getDead());
		assertEquals('*', result.getAlive());
	}


	@Test
	public void testGetAlive_1()
		throws Exception {
		Cell fixture = new Cell('*', '.');

		char result = fixture.getAlive();

		
		assertEquals('*', result);
	}


	@Test
	public void testGetDead_1()
		throws Exception {
		Cell fixture = new Cell('*', '.');

		char result = fixture.getDead();

		// add additional test code here
		assertEquals('.', result);
	}


	@Test
	public void testSetAlive_1()
		throws Exception {
		Cell fixture = new Cell('*', '.');
		char Alive = '*';

		fixture.setAlive(Alive);

	
	}


	@Test
	public void testSetDead_1()
		throws Exception {
		Cell fixture = new Cell('*', '.');
		char Dead = '.';

		fixture.setDead(Dead);

	
	}



	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CellTest.class);
	}
}