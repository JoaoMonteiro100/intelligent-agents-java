package logic;

import java.util.ArrayList;

public abstract class Player {
	
	protected int money;
	protected Boolean extraChannel, overseer;
	
	
	public Player(){
		this.money = 100;
		this.extraChannel = true;
		this.overseer = false;
	}
	
	public void pay(int quantity){
		this.money += quantity;
	}
	
	public Boolean receive(int quantity){
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
	
	public abstract int bid(int maxBid);
}
