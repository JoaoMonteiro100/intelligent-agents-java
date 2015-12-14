package logic;

public class Spender extends Player{
	public int bid(int maxBid){
		if(maxBid <= money) { //if he has enough money, he'll always outbid
			return maxBid+1;
		}
		else return money; //else he will try to NOT be the overseer, as to be able to spend money on bribes
	}

	@Override
	public int bribe(int overseer) {
		// TODO bribe
		return 0;
	}
}
