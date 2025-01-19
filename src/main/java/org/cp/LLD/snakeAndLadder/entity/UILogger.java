package org.cp.LLD.snakeAndLadder.entity;

public class UILogger implements IObserver{
    @Override
    public void notifyGameEvent(String message) {
        System.out.println(message);
    }

    @Override
    public void notifyGameEnd(Player player) {
        System.out.println("Winner is " + player.getName());
    }
}
