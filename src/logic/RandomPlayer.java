package logic;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPlayer extends Player {

	public int bid(int maxBid){
		int coin = ThreadLocalRandom.current().nextInt(0,2);
		if (maxBid+1 < 0.3*money && coin == 1){
			return ThreadLocalRandom.current().nextInt(maxBid + 1, (int) (0.3 * money));
		}
		else if (coin == 1) {
			return ThreadLocalRandom.current().nextInt(0, maxBid);
		}
		return 0;
	}

	@Override
	public int bribe(int overseer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
