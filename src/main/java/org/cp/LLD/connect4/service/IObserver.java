package org.cp.LLD.connect4.service;

import org.cp.LLD.connect4.entity.Player;

public interface IObserver {
    public void notifyGameEvent(String message);
    public void notifyGameEnd(Player player);
}
