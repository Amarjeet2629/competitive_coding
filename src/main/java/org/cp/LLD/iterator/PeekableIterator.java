package org.cp.LLD.iterator;

import java.util.List;

public class PeekableIterator<T> implements Iterator<T>{
    List<T> collections;
    int index = 0;

    PeekableIterator(List<T> collections){
        this.collections = collections;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index != collections.size();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No Such element");

        T value = collections.get(index);
        index++;

        return value;
    }

    public T peek(){
        if(!hasNext()) throw new RuntimeException("No such element");

        return collections.get(index);
    }
}
