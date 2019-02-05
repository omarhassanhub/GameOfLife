
public class Grid {

	  Cell cell;
	  private char isAlive;
	  private char isDead;
	
	  public Grid(){
		
		 cell = new Cell('*', '.');
		 cell.setAlive('*');
		 cell.setDead('.');
		 isAlive = cell.getAlive();
		 isDead = cell.getDead();
		 
		  
	}
	  
	//Initialise a new state
	private  char[][] getState(int gridSize) {
		char[][] State = new char[gridSize][gridSize];
		for (int row = 0; row < gridSize; row++) {
			for (int col = 0; col < gridSize; col++)
				State[row][col] = isDead;
		}
		return State;
	}
		
	  //Get each state when the game evolves each turn.
	public  char[][] getSpecificState(int n, char[][] initialSeed,
			int seedSize) {
		char[][] state = initialSeed;
		for (int i = 0; i < n; i++) {
			state = getNextState(state, seedSize);
		}
		return state;
	}
	
	
	//Count live neighbours around each adjacent cell
	public int getAliveAroundCell(int row, int col, char[][] grid) {
		int aliveNeighbours = 0;
		
		//Top row 
		if (grid[row - 1][col - 1] == isAlive)
			aliveNeighbours++;
		
		if (grid[row - 1][col] == isAlive)
			aliveNeighbours++;
		if (grid[row - 1][col + 1] == isAlive)
			aliveNeighbours++;
		//Middle row
		if (grid[row][col - 1] == isAlive)
			aliveNeighbours++;
		if (grid[row][col + 1] == isAlive)
			aliveNeighbours++;
		//Bottom row
		if (grid[row + 1][col - 1] == isAlive)
			aliveNeighbours++;
		if (grid[row + 1][col] == isAlive)
			aliveNeighbours++;
		if (grid[row + 1][col + 1] == isAlive)
			aliveNeighbours++;
		 	
		return aliveNeighbours;
	}
	//Apply rules for the next State 
	public  char[][] getNextState(char[][] grid, int gridSize) {
		char[][] nextState = getState(gridSize);

		for (int row = 0; row < gridSize; row++) {
			if (row + 1 < gridSize && row > 0) {
				for (int col = 0; col < gridSize; col++) {
					if (col + 1 < gridSize && col  > 0) {
						int aliveNeighbours = getAliveAroundCell(row, col, grid);

						if (underOrOverPopulation(aliveNeighbours))
							nextState[row][col] = isDead;
						if (survival(aliveNeighbours, grid, row, col))
							nextState[row][col] = isAlive;
						if (creationOfLife(aliveNeighbours,grid, row, col))
							nextState[row][col] = isAlive;
					}
				}
			}
		}
		return nextState;
	}

	/*
	 * When a live cell has fewer than two neighbours
	 * or more than three neighbours.
	 * 
	 */

	private  boolean underOrOverPopulation(int aliveNeighbours) {
		if (aliveNeighbours < 2 || aliveNeighbours > 3)
			return true;
		else
			return false;
	}
	
	/*
	 * When a live cell has two or three neighbours
	 */
	private  boolean survival(int aliveNeighbours,
			char[][] grid, int row, int col) {
		if ((aliveNeighbours >= 2 && aliveNeighbours <= 3) && grid[row][col] == isAlive)
			return true;
		else
			return false;

	}
	/*
	 * When an empty position has exactly three neighbouring cells
	 */
	private  boolean creationOfLife(int aliveNeighbours,
			char[][] grid, int row, int col) {
		if ((grid[row][col] == isDead) && (aliveNeighbours == 3))
			return true;
		else
			return false;
	}

	//Display the grid along with its current values
	public void displayState(char[][] grid, int gridSize) {
			for (int row = 0; row < gridSize; row++) {
				for (int col = 0; col < gridSize; col++) 
					System.out.print(grid[row][col]);
				System.out.println();
			}
			System.out.println();
		}
}
