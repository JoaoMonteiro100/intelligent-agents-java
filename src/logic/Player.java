package logic;

public class Player {
	
	private float money;
	private Boolean extraChannel, overseer;
	private String name;
	
	
	public Player(String name){
		this.name = name;
		this.money = 10;
		this.extraChannel = true;
		this.overseer = false;
	}


	public String getName() {
		return name;
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
	
}
