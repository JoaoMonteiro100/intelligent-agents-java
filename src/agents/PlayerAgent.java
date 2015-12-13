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
				sendReply(msg, "B" + playerInfo.bid(maxBid), ACLMessage.PROPOSE); //TODO:Arranjar fórmulas para as bids
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
