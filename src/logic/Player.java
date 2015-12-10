package logic;

public abstract class Player {
	
	protected double money;
	protected Boolean extraChannel, overseer;
	
	
	public Player(){
		this.money = 10;
		this.extraChannel = true;
		this.overseer = false;
	}
	
	public void pay(float quantity){
		this.money += quantity;
	}
	
	public Boolean receive(float quantity){
		if(money >= quantity){
			this.money -= quantity;
			return true;
		}
		return false;
	}
	
	public Boolean hasExtraChannel(){
		return extraChannel;
	}
	
	public Boolean isOverseer(){
		return overseer;
	}
	
	public abstract double bid();
}
