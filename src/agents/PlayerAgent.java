package agents;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import logic.Player;
import logic.RandomPlayer;
import logic.Rational;
import logic.Spender;

public class PlayerAgent extends MyAgent {
	
	private static final long serialVersionUID = 1L;
	private Player playerInfo;
	private Boolean gameOver = false;
	private int overseer = 0;
	private int[] frequency = new int[6];
	private int lastBid = 0;
	//POTATO,TOMATO,BANANA,APPLE,ORANGE,ONION;

	private class PlayerBehaviour extends MyBehaviour {
		
		private static final long serialVersionUID = 1L;

		@Override
		public void action(){
			ACLMessage msg = blockingReceive();
			String[] parts = msg.getContent().split("-");
			switch(parts[0]){
			case "STARTA": //joining game as a random agent
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				playerInfo = new RandomPlayer();
				break;
			case "STARTR": //joining game as a rational agent
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				playerInfo = new Rational();
				break;
			case "STARTS": // joining game as spender agent
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				playerInfo = new Spender();
				break;
			case "BID": // bid on plantations
				int maxBid = Integer.parseInt(parts[1]);
				lastBid = playerInfo.bid(maxBid);
				sendReply(msg, "B" + lastBid, ACLMessage.PROPOSE); //TODO:Arranjar fórmulas para as bids para Spender e Rational
				break;
			case "OVERSEER": //receiving info on who is overseer
				overseer = Integer.parseInt(parts[1]);
				int bribeAmount = playerInfo.bribe();
				sendMessage("player" + overseer, "BR-" + bribeAmount, ACLMessage.PROPOSE);
				break;
			case "CHOOSEW": //if first player choosing (won bidding)
				String options = parts[1] + parts[2] + parts[3] + parts[4] + parts[5];
				String choice = playerInfo.choosePlantation(options, frequency);
				playerInfo.pay(lastBid);
				break;
			case "CHOOSE": //if lost bidding
				//TODO: caso onde o jogador não ganhou o leilão
				break;
			case "OCCURENCES":
				//for(int i = 0; i < occurences.length; i++)
					//occurences[i] = Integer.parseInt(parts[i+1]);
				break;
			default:
				break;
			}
		}
		
		@Override
		public boolean done() {
			return gameOver;
		}
	};

	protected void setup() {
		
		registryDF("Player", getAID().getLocalName());
		
		// Printout a welcome message
		System.out.println("Hi "+ getAID().getLocalName() +" is ready.");
				
		for(int i = 0; i < frequency.length; i++)
			frequency[i] = 0;
		
		addBehaviour(new PlayerBehaviour());
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
