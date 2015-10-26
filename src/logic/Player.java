package logic;

import java.util.List;

public abstract class Player {
	private float money;
	private List<Plantation> properties;

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
	public void addMoney(float money) {
		this.money += money;
	}
	
	public List<Plantation> getProperties() {
		return properties;
	}

	public void setProperties(List<Plantation> properties) {
		this.properties = properties;
	}

	public void addProperty(Plantation property) {
		this.properties.add(property);
	}
}
