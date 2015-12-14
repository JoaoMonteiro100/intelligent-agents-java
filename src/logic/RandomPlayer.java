package logic;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPlayer extends Player {

	public int bid(int maxBid){
		if (maxBid+1 < 0.3*money){
			int coin = ThreadLocalRandom.current().nextInt(0,2);
			if(coin == 1)
				return ThreadLocalRandom.current().nextInt(maxBid + 1, (int) (0.3 * money));
		}
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

}
