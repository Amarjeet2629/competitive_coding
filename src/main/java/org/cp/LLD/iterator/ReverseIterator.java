package org.cp.LLD.iterator;

import java.util.ArrayList;
import java.util.List;

public class ReverseIterator<T> implements Iterator<T>{
    private final List<T> collections = new ArrayList<>();
    private int index;
    public ReverseIterator(List<T> collections){
        this.collections.addAll(collections);
        index = collections.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        T value = collections.get(index);
        index--;

        return value;
    }
}
