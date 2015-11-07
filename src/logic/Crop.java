package logic;

public class Crop extends Land {
	private String type;
	private int workers;
	private Boolean isIrrigated;
	private Boolean isDesert;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWorkers() {
		return workers;
	}
	public void setWorkers(int lives) {
		this.workers = lives;
	}
	public void removeWorker() {
		this.workers--;
		if(this.workers == 0) {
			isDesert = true;
		}
	}
	public Boolean getIsIrrigated() {
		return isIrrigated;
	}
	public void setIsIrrigated(Boolean isIrrigated) {
		this.isIrrigated = isIrrigated;
	}
}
