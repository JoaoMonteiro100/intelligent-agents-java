package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class Game {
	
	private Map<String, Player> players;
	
	public Game(){
		players = new HashMap<String, Player>();		
	}
	
	public void addPlayer(String name, Player p){
		players.put(name, p);
	}
	
	public Player shuffleTurn() {
		
		Random random = new Random();
		List<String> keys = new ArrayList<String>(players.keySet());
		String randomKey = keys.get(random.nextInt(keys.size()) );
		Player value = players.get(randomKey);
		
		return value;
	}
}
