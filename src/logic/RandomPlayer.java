package logic;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPlayer extends Player {

	public int bid(int maxBid){
		int coin = ThreadLocalRandom.current().nextInt(0,2); //he tosses a coin (heads or tails)
		if (maxBid+1 < 0.3*money && coin == 1){ //if he has enough money and it was heads
			return ThreadLocalRandom.current().nextInt(maxBid + 1, (int) (0.3 * money) + 1); //he will bid some affordable amount
		}
		else if (coin == 1) { //if he doesn't have enough money and it was heads
			return ThreadLocalRandom.current().nextInt(1, maxBid); //he will bid lower than the max bid
		}
		return 0; //if he doesn't have enough money and was tails, he passes
	}

	@Override
	public int bribe() {
		int coin = ThreadLocalRandom.current().nextInt(0,2);
		if(coin == 1)
			return ThreadLocalRandom.current().nextInt(0 + 1, (int) (0.3 * money));
		return 0;
	}
	
	@Override
	public String choosePlantation(String list, int[] occurences) {
		String[] parts = list.split("-");
		int choice = ThreadLocalRandom.current().nextInt(0,parts.length);
		return parts[choice];
	}

}
