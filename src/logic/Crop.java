package logic;

public class Crop {
	private String type;
	private int workers;
	private Boolean irrigated;
	
	public Crop(String type, int workers){
		this.type = type;
		this.workers = workers;
		this.irrigated = false;
	}
	
	public void irrigate(){
		this.irrigated = true;
	}
	
}
