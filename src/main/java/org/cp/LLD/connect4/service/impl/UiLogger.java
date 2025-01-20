package org.cp.LLD.connect4.service.impl;

import org.cp.LLD.connect4.entity.Player;
import org.cp.LLD.connect4.service.IObserver;

public class UiLogger implements IObserver {
    @Override
    public void notifyGameEvent(String message) {
        System.out.println(message);
    }

    @Override
    public void notifyGameEnd(Player player) {
        if(player == null){
            System.out.println("No player was able to win the game");
        } else {
            System.out.println("Winner is :" + player.getName());
        }
    }
}
