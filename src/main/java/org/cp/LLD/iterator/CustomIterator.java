package org.cp.LLD.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomIterator<T> implements Iterator<T>{
    Queue<Iterator<T>> iteratorQueue = new LinkedList<>();

    public CustomIterator(List<Iterator<T>> iteratorList){
        iteratorQueue.addAll(iteratorList);
    }

    @Override
    public boolean hasNext() {
        return !iteratorQueue.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No such element");
        Iterator<T> currentIterator = iteratorQueue.poll();
        T value = currentIterator.next();

        if(currentIterator.hasNext()){
            iteratorQueue.add(currentIterator);
        }

        return value;
    }
}
