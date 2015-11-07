package logic;

import java.util.List;

public abstract class Player {
	private float money;
	private List<Crop> properties;

	protected Player() {
		money = 10;
	}
	
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
	public void addMoney(float money) {
		this.money += money;
	}
	
	public List<Crop> getProperties() {
		return properties;
	}

	public void setProperties(List<Crop> properties) {
		this.properties = properties;
	}

	public void addProperty(Crop property) {
		this.properties.add(property);
	}
}
