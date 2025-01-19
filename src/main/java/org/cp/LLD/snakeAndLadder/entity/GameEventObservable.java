package org.cp.LLD.snakeAndLadder.entity;

import java.util.ArrayList;
import java.util.List;

public class GameEventObservable implements IObservable{
    List<IObserver> observerList;

    public GameEventObservable(){
        observerList = new ArrayList<>();
    }

    @Override
    public void notifyGameEvent(Player player, String message) {
        for(IObserver observer: observerList){
            observer.notifyGameEvent(player.getName() + message);
        }
    }

    @Override
    public void notifyGameEnd(Player player) {
        for(IObserver observer : observerList){
            observer.notifyGameEnd(player);
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }
}
