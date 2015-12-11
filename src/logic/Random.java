package logic;

import java.util.concurrent.ThreadLocalRandom;

public class Random extends Player {

	public int bid(){
		return ThreadLocalRandom.current().nextInt(0, 405);
	}
}
