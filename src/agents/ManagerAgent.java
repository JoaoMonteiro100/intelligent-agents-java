package agents;

import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import logic.Game;
import logic.Player;

public class ManagerAgent extends MyAgent {

	private static final long serialVersionUID = 1L;
	private static final int N_PLAYERS = 5;
	private static final int N_ROUNDS = 9;
	private Game gameInfo;
	
	private class ManagerBehaviour extends MyBehaviour{
		
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
				Player p = new Player(playerName);
				gameInfo.addPlayer(playerName, p);
				sendMessage(playerName, "START", ACLMessage.PROPOSE);
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
			sendMessage(gameInfo.shuffleTurn().getName(), "PLAY", ACLMessage.REQUEST);
			
			//Game on bitches
			
		}

		@Override
		public boolean done() {
			return true;
		}
	};
	
	protected void setup() {
		
		gameInfo = new Game();
		
		registryDF("Manager", getAID().getLocalName());
		
		// Printout a welcome message
		System.out.println("Manager is alive");
		
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
