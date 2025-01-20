package org.cp.LLD.ticTacToe.entity;

import java.util.ArrayList;
import java.util.List;

public class GameEventNotifier implements IObservable{
    List<IObserver> observerList;

    public GameEventNotifier(){
        observerList = new ArrayList<>();
    }

    @Override
    public void notifyGameEvent(String message) {
        for(IObserver observer : observerList){
            observer.notifyGameEvent(message);
        }
    }

    @Override
    public void notifyGameEnd(Player player) {

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
