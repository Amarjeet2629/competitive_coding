package org.cp.LLD.iterator;

import java.util.List;

public class CycleIterator<T> implements Iterator<T>{
    List<T> collection;
    int cycleCount = 0;
    int index = 0;

    CycleIterator(List<T> collection, int cycleCount){
        this.collection = collection;
        this.cycleCount = cycleCount;
    }

    @Override
    public boolean hasNext() {
        return cycleCount != 0;
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No such element");
        T value = collection.get(index);
        index += 1;

        if(index == collection.size()){
            index = 0;
            cycleCount--;
        }

        return value;
    }
}
