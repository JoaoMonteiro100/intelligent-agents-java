package logic;

/*
 * Any square on the board (includes empty lots, squares, wells and rivers)
 */
public class Lot {
	protected Boolean irrigated;
	
	public Lot(){
		this.irrigated = false;
	}
	
	public void irrigate(){
		this.irrigated = true;
	}
	
	public Boolean isIrrigated() {
		return this.irrigated;
	}
}
