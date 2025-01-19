package org.cp.LLD.ticTacToe.entity;


public interface IObservable {
    public void notifyGameEvent(String message);
    public void notifyGameEnd(Player player);
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
}
