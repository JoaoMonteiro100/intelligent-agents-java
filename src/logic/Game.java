package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class Game {
	
	private Map<String, Player> players;
	private Board board;
	
	public Game(){
		players = new HashMap<String, Player>();
		board = new Board();
	}
	
	public void addPlayer(String name, Player p){
		players.put(name, p);
	}
	
	public String shuffleTurn() {
		
		Random random = new Random();
		List<String> keys = new ArrayList<String>(players.keySet());
		String randomKey = keys.get(random.nextInt(keys.size()) );
		
		return randomKey;
	}
	
	public String overseerName(){
		
		for(int i = 0; i < players.keySet().size(); i++){
			String name = players.keySet().toArray()[i].toString();
			if(players.get(name).isOverseer())
					return name;
		}
		
		return null;
			
	}
}
