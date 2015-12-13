package agents;

import java.util.Scanner;

import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import logic.*;

public class ManagerAgent extends MyAgent {

	private static final long serialVersionUID = 1L;
	private static final int N_PLAYERS = 5;
	private Game gameInfo;
	private Boolean gameOver;
	private int playerTurn, maxBid, nBids, bestBidder;
	
	private class StartingBehaviour extends MyBehaviour{
		
		private static final long serialVersionUID = 1L;

		@Override
		public void action(){
				
			//Wait for the setting up of the four players
			AID[] result;
			while ((result = searchPlayers()).length != N_PLAYERS)
				block();

			//Sending a message to the four players to begin the game and saving players in gameInfo
			for(int i = 0; i < result.length; i++){
				String playerName = result[i].getLocalName();
				System.out.println("Choose " + playerName + " strategy: A-Random | R-Rational | S-Spender");
				Scanner reader = new Scanner(System.in);
				char c = reader.findInLine(".").charAt(0);
				switch(c){
				case 'A':
					Random a = new Random();
					gameInfo.addPlayer(playerName, a);
					break;
				case 'R':
					Rational r = new Rational();
					gameInfo.addPlayer(playerName, r);
					break;
				case 'S':
					Spender s = new Spender();
					gameInfo.addPlayer(playerName, s);
					break;
				}
				sendMessage(playerName, "START" + c + "-", ACLMessage.PROPOSE);
				//reader.close();
			}
			
			//Wait acknowledgment of the four players to start the game
			ACLMessage msg; 
			int counter = 0;
			
			while(counter != N_PLAYERS){
				msg = blockingReceive();
				String content = msg.getContent();
				int performative = msg.getPerformative();
				
				if(content.equals("GAME") && performative == ACLMessage.ACCEPT_PROPOSAL){
					counter++;
				}
			}
			
			//Randomly choose first player to play and tell him that
			playerTurn = gameInfo.shuffleTurn();
			sendMessage("player" + playerTurn, "BID-0", ACLMessage.REQUEST);
		}

		@Override
		public boolean done() {
			return true;
		}
	};
	
	private class ManagerBehaviour extends MyBehaviour{

		private static final long serialVersionUID = 1L;

		@Override
		public void action() {
			if(nBids < N_PLAYERS){
				ACLMessage msg = blockingReceive();
				String[] a = msg.getContent().split("B");
				int bid = Integer.parseInt(a[1].trim());
				System.out.println("A bid do " + msg.getSender().getLocalName() + " foi " + bid);
				if(bid > maxBid){
					maxBid = bid;
					bestBidder = playerTurn;
				}
				nBids += 1;
				
				if(playerTurn == 5)
					playerTurn = 1;
				else playerTurn += 1;
				
				sendMessage("player" + playerTurn, "BID-" + maxBid, ACLMessage.REQUEST);
			}
			else{
				System.out.println("Best bidder was player " + bestBidder);
				gameOver = true;
			}
			//else escolher cartas e subornos
		}

		@Override
		public boolean done() {
			return gameOver;
		}
		
	};
	
	protected void setup() {
		
		gameInfo = new Game();
		gameOver = false;
		nBids = 0; 
		maxBid = 0;
		bestBidder = 0;
		registryDF("Manager", getAID().getLocalName());
		
		// Printout a welcome message
		System.out.println("Manager ready");
		
		addBehaviour(new StartingBehaviour());
		addBehaviour(new ManagerBehaviour());
	}
	
	protected void takeDown() {
		 
		try {
			 DFService.deregister(this);
		 }
		 catch (FIPAException fe) {
			 fe.printStackTrace();
		 }		 
	}

}
