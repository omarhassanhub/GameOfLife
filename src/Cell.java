public class Cell {
	private char Alive;
	private char Dead;
	
	/*Getter and Setter methods to assign/retrieve
	* cell values
	*/
	protected Cell(char Alive, char Dead){
		this.Alive = Alive;
		this.Dead = Dead;
	}
	
	protected char getAlive() {
		return Alive;
	}

	protected void setAlive(char Alive) {
		this.Alive = Alive;
	}
	
	protected char getDead() {
		return Dead;
	}

	protected void setDead(char Dead) {
		this.Dead = Dead;
	}
}