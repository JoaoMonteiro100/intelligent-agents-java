package logic;

/*
 * A square on the board on which there is a plantation
 */
public class Crop extends Lot {
	private String vegetable;
	private int workers;
	private Boolean dry = false;
	
	public Crop(String type, int workers){
		this.vegetable = type;
		this.workers = workers;
	}

	public String getType() {
		return vegetable;
	}

	public void setType(String type) {
		this.vegetable = type;
	}

	public int getWorkers() {
		return workers;
	}

	public void setWorkers(int workers) {
		this.workers = workers;
	}
	
	public void reduceWorkers() {
		if(this.workers > 0) {
			this.workers--;
		}
		else {
			this.dry = true;
		}
	}
}
