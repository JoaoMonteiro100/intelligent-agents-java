package logic;

/*
 * A square on the board on which there is a plantation
 */
public class Crop extends Lot {
	private String type;
	private int workers;
	
	public Crop(String type, int workers){
		this.type = type;
		this.workers = workers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWorkers() {
		return workers;
	}

	public void setWorkers(int workers) {
		this.workers = workers;
	}
}
