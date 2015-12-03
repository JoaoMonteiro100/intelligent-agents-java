package agents;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import logic.Player;

public class PlayerAgent extends MyAgent {
	
	private static final long serialVersionUID = 1L;
	private Player playerInfo;
	private class PlayerBehaviour extends MyBehaviour {
		
		private static final long serialVersionUID = 1L;

		@Override
		public void action(){
			
			//Receiving a message
			ACLMessage msg = blockingReceive();
			String content = msg.getContent();
			String sender = msg.getSender().getLocalName();
			
			//If message received from manager telling people to start
			if(sender.equals("manager") && content.equals("START"))
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL); //Accept START proposal

		}
		
		@Override
		public boolean done() {
			return false;
		}
	};

	protected void setup() {
		
		this.playerInfo = new Player(getAID().getLocalName());
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
