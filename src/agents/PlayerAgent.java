package agents;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import logic.Player;
import logic.Random;
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
			
			//Game cycle TODO: Continuar a meter aí mais mensagens
			ACLMessage msg = blockingReceive();
			switch(msg.getContent()){
			case "STARTA": //confirma entrada em jogo
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				playerInfo = new Random();
				break;
			case "STARTR":
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				playerInfo = new Rational();
				break;
			case "STARTS":
				sendReply(msg, "GAME", ACLMessage.ACCEPT_PROPOSAL);
				playerInfo = new Spender();
				break;
			case "BID": //pedido de licitacao no leilao de plantacoes
				sendReply(msg, "B" + playerInfo.bid(), ACLMessage.PROPOSE); //TODO:Arranjar fórmulas para as bids
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
