package org.cp.LLD.snakeAndLadder.entity;

public interface IObserver {
    public void notifyGameEvent(String message);
    public void notifyGameEnd(Player player);
}
