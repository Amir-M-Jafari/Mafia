package com.company;

public class NonMayorTreat extends Behaviour{

    public NonMayorTreat(Character character) {
        super(character);
    }

    @Override
    public void run() {
        receiveMessage();

        if(client.getGameMode() == Mode.MayorTime){
            sendMessage(new Message("God","Mayor Time, Can not say anything :|"));
        }
        // TODO handle sticking
    }
}
