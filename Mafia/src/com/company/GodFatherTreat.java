package com.company;

import java.util.HashMap;
import java.util.Map;

public class GodFatherTreat extends Behaviour{

    public GodFatherTreat(Character character) {
        super(character);
    }

    @Override
    public void run() {

        if(behaviourDone)
            return;

        HashMap<ClientHandler,ClientHandler> voteMap = MafiasVoteTimeBehaviour.getVoteMap();
        for(Map.Entry<ClientHandler, ClientHandler> entry : voteMap.entrySet()){
            sendMessage(new Message("God", entry.getKey().getClientName() + " votes to " +
                    entry.getValue().getClientName()));
        }
        sleepThread(3000);
        sendMessage(new Message("God", "Now choose someone you want to kill"));

        while(true){
            Message message = receiveMessage();

            if (ClientHandler.isClientName(message.getText()) != null) {


                ClientHandler myVote = ClientHandler.isClientName(message.getText());
                game.setGodFatherChoice(myVote);
                sendMessage(new Message("God", "Done"));
                break;


            } else {
                sendMessage(new Message("God", ":|"));
            }
        }
        behaviourDone = true;
    }


}
