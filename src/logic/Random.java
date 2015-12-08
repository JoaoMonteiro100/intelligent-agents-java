package logic;

import java.util.concurrent.ThreadLocalRandom;

public class Random extends Player {

	public double bid(){
		return ThreadLocalRandom.current().nextDouble(0, 0.3);
	}
}
