package logic;

import java.util.concurrent.ThreadLocalRandom;

/*
 * A square on the board on which there is a plantation
 */

public class Crop extends Lot {
	
	public enum Vegetable {
		POTATO, 
		TOMATO, 
		BANANA, 
		APPLE, 
		ORANGE, 
		ONION;
		
		public static Vegetable getRandom() {
	        return values()[(int) (Math.random() * values().length)];
	    }
	}
	
	private Vegetable vegetable;
	private int workers;
	private Boolean dry;
	private Player owner;
	
	public Crop(Vegetable type, int workers){
		this.vegetable = type;
		this.workers = workers;
		this.dry = false;
	}

	public Vegetable getType() {
		return vegetable;
	}

	public void setType(Vegetable type) {
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
	
	public Boolean isDry(){
		return this.dry;
	}
	
	public static Crop sortCrop(){
		Vegetable veg = Vegetable.getRandom();
		int workers = ThreadLocalRandom.current().nextInt(1,4);
		Crop c = new Crop(veg, workers);
		return c;
	}

	@Override
	public String toString() {
		return "" + vegetable + workers;
	}

}
