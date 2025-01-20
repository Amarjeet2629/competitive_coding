package org.cp.LLD.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagIterator<T> implements Iterator<T>{
    List<List<T>> nestedLists;
    Queue<java.util.Iterator<T>> iteratorQueue;

    ZigZagIterator(List<List<T>> nestedLists){
        this.nestedLists = nestedLists;
        iteratorQueue = new LinkedList<>();

        for(List<T> currentList: nestedLists){
            iteratorQueue.add(currentList.iterator());
        }

    }

    @Override
    public boolean hasNext() {
        return !iteratorQueue.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No such element");

        java.util.Iterator<T> currentIterator = iteratorQueue.poll();
        T value = currentIterator.next();

        if(currentIterator.hasNext()){
            iteratorQueue.add(currentIterator);
        }

        return value;

    }
}
