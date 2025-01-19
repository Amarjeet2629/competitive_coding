package org.cp.LLD.snakeAndLadder.entity;

public interface IObservable {
    public void notifyGameEvent(Player player, String message);
    public void notifyGameEnd(Player player);
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
}
