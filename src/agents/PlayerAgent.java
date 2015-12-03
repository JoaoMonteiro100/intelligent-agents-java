package agents;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import logic.Player;

public class PlayerAgent extends MyAgent {
	
	private static final long serialVersionUID = 1L;
	private Player playerInfo;
	private Boolean gameOver = false;
	private class PlayerBehaviour extends MyBehaviour {
		
		private static final long serialVersionUID = 1L;

		@Override
		public void action(){
			
			//Game cycle
			ACLMessage msg = blockingReceive();
			switch(msg.getContent()){
			case "START": //confirma entrada em jogo
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				break;
			case "BID": //pedido de licitacao no leilao de plantacoes
				System.out.println(getAID().getLocalName() + " sera o primeiro a jogar");
				break;				
			}
		}
		
		@Override
		public boolean done() {
			return gameOver;
		}
	};

	protected void setup() {
		
		this.playerInfo = new Player();
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
