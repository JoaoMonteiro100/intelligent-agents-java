package logic;

public class Spender extends Player{
	
	public int bid(int maxBid){
		return money;
	}

	@Override
	public int bribe() {
		return (int) ((int) money*0.2);
	}

	@Override
	public String choosePlantation(String list, int[] occurences) {
		// TODO Auto-generated method stub
		return null;
	}
}
