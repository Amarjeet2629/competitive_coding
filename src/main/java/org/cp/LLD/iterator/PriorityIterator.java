package org.cp.LLD.iterator;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityIterator<T> implements Iterator<T>{
    private final PriorityQueue<T> collections;

    public PriorityIterator(List<T> collections, Comparator<T> comparator){
        this.collections = new PriorityQueue<>(comparator);
        this.collections.addAll(collections);
    }

    @Override
    public boolean hasNext() {
        return !collections.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No such element");

        return collections.poll();
    }
}
