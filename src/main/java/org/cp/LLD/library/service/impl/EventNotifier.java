package org.cp.LLD.library.service.impl;

import org.cp.LLD.library.models.Book;
import org.cp.LLD.library.service.IObservable;
import org.cp.LLD.library.service.IObserver;

import java.util.ArrayList;
import java.util.List;

public class EventNotifier implements IObservable {
    List<IObserver> observerList = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void emitFilterResult(Book book) {
        for(IObserver observer: observerList){
            observer.emitFilterResult(book);
        }
    }

    @Override
    public void invalidSearch(String message) {
        for(IObserver observer: observerList){
            observer.invalidSearch(message);
        }
    }

    @Override
    public void informationMessage(String message) {
        for(IObserver observer: observerList){
            observer.informationMessage(message);
        }
    }
}
