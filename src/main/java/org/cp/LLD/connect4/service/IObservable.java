package org.cp.LLD.connect4.service;

import org.cp.LLD.connect4.entity.Player;

public interface IObservable {
    public void add(IObserver observer);
    public void remove(IObserver observer);
    public void notifyGameEvent(String message);
    public void notifyGameEnd(Player player);

}
