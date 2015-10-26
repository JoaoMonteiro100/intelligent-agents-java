package logic;

public class Plantation {
	private float area;
	private float production;
	
	public float getArea() {
		return area;
	}
	
	public void setArea(float area) {
		this.area = area;
	}
	
	public float getProduction() {
		return production;
	}
	
	public void setProduction(float production) {
		this.production = production;
	}
	
	public void increaseProduction(float extra) {
		this.production += extra;
	}
	
	public void decreaseProduction(float minus) {
		this.production -= minus;
	}
}
