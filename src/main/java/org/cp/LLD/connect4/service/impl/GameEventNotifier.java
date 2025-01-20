package org.cp.LLD.connect4.service.impl;

import org.cp.LLD.connect4.entity.Player;
import org.cp.LLD.connect4.service.IObservable;
import org.cp.LLD.connect4.service.IObserver;

import java.util.ArrayList;
import java.util.List;

public class GameEventNotifier implements IObservable {
    List<IObserver> observerList = new ArrayList<>();

    @Override
    public void add(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyGameEvent(String message) {
        observerList.forEach(observer -> observer.notifyGameEvent(message));
    }

    @Override
    public void notifyGameEnd(Player player) {
        observerList.forEach(observer -> observer.notifyGameEnd(player));
    }
}
