package org.cp.LLD.ticTacToe.entity;

import org.cp.LLD.snakeAndLadder.entity.Player;

public class UILogger implements IObserver{
    @Override
    public void notifyGameEvent(String message) {
        System.out.println(message);
    }

    @Override
    public void notifyGameEnd(Player player) {
        if(player == null){
            System.out.println("Game was Tie !!!");
        } else {
            System.out.println("Winner is: " + player.getName());
        }
    }
}
