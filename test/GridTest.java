import org.junit.*;
import static org.junit.Assert.*;


public class GridTest {


	@Test
	public void testDisplayState_1()
		throws Exception {
		Grid fixture = new Grid();
		fixture.cell = new Cell('*', '.');
		char[][] grid = new char[][] {{ '.', '.', '.', '.', '.' }};
		int gridSize = 1;

		fixture.displayState(grid, gridSize);

		}



	@Test
	public void testGetAliveAroundCell_1()
		throws Exception {
		Grid fixture = new Grid();
		fixture.cell = new Cell('*', '.');
		int row = 1;
		int col = 1;
		char[][] grid = new char[][] {null, null};

		int result = fixture.getAliveAroundCell(row, col, grid);

		assertEquals(0, result);
	}


	@Test
	public void testGetState_1()
		throws Exception {
		Grid fixture = new Grid();
		fixture.cell = new Cell('*', '.');
		char[][] grid = new char[][] {};
		int gridSize = 2;

		char[][] result = fixture.getNextState(grid, gridSize);

		assertNotNull(result);
	}

	@Test
	public void testGetSpecificState_1()
		throws Exception {
		Grid fixture = new Grid();
		fixture.cell = new Cell('*', '.');
		int n = 1;
		char[][] initialSeed = new char[][] {};
		int seedSize = 1;

		char[][] result = fixture.getSpecificState(n, initialSeed, seedSize);

		assertNotNull(result);
	}


	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GridTest.class);
	}
}