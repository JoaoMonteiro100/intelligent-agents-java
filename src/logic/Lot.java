package logic;

/*
 * Any square on the board (includes empty lots, squares, wells and trenches)
 */
public class Lot {
	protected Boolean isIrrigated;
	
	public Lot(){
		this.isIrrigated = false;
	}
	
	public void irrigate(){
		this.isIrrigated = true;
	}
	
	public Boolean isIrrigated() {
		return this.isIrrigated;
	}
}
