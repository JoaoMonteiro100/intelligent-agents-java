package logic;

public class Spender extends Player{
	public int bid(int maxBid){
		if(maxBid+1 <= (0.7*money)) { //if he has barely enough money
			return maxBid+1; //he'll try to outbid
		}
		else return money; //else he will try to NOT be the overseer, as to be able to spend money on bribes
	}

	@Override
	public int bribe(int overseer) {
		// TODO bribe
		return 0;
	}
}
