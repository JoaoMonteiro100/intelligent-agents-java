package logic;

public class Rational extends Player {
	
	public int bid(int maxBid){
		if(maxBid > (money/2)){ //if the bid is too high or he has too little money
			return 0; //will try to become overseer to win some money through bribes
		}
		else { //otherwise, he bids
			return maxBid+1;
		}
	}

	@Override
	public int bribe(int overseer) {
		// TODO Auto-generated method stub
		return 0;
	}
}
