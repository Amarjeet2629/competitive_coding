package org.cp.LLD.ticTacToe.entity;

import org.cp.LLD.snakeAndLadder.entity.Player;

public interface IObserver {
    public void notifyGameEvent(String message);
    public void notifyGameEnd(Player player);
}
