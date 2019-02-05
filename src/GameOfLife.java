import java.util.*;
import java.util.Scanner;

public class GameOfLife {
	public static void runGame(){
		
		Grid grid = new Grid();
		int stateNumber;
		int seedSize = 5;
		
		System.out.println("Initial State (Key: * = live cell):");
		grid.displayState(initialSeedGrid(), seedSize);
		Scanner in = new Scanner(System.in);
		boolean isNumeric = false;
		while(!isNumeric)
			
		try{
		    
		System.out.println("Step through the game by entering " +
							"a value e.g. Enter 1 or 2\n" +
							"Or Enter -1 to terminate");

		stateNumber = in.nextInt();
		in.nextLine();
		if(stateNumber == -1){
			System.out.println("End of game");
			break;
		}
		
		char[][] specificState = grid.getSpecificState(stateNumber, 
					initialSeedGrid(), seedSize);
		
		System.out.println("After " + stateNumber + " state:");
		grid.displayState(specificState, seedSize);
		isNumeric = false;
		
		}catch (InputMismatchException  ex) {
		   System.out.println("Invalid character, type a numeric value.");
		   in.nextLine();
		}
	}

public static char[][] initialSeedGrid(){
		
		char[][] initialSeedGrid = 
			{{ '.', '.', '.', '.', '.' }, 
			{ '.', '.', '*', '.', '.' }, 
			{ '.', '.', '*', '.', '.' }, 
			{ '*', '.', '*', '*', '.' }, 
			{ '.', '.', '.', '.', '.' },
			};
		return initialSeedGrid;
		
	}
	public static void main(String args[]) {
		System.out.println("Game of life\n\n");
		runGame();
	}

}



