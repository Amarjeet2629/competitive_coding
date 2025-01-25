package org.cp.LLD.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChunkedIterator2<T> implements Iterator<List<T>>{
    List<T> collections = new ArrayList<>();
    BasicIterator<T> basicIterator;
    int chunkSize;

    public ChunkedIterator2(List<T> collections, int chunkSize){
        this.collections.addAll(collections);
        this.chunkSize = chunkSize;
        this.basicIterator = new BasicIterator<>(collections);
    }

    @Override
    public boolean hasNext() {
        return basicIterator.hasNext();
    }

    @Override
    public List<T> next() {
        if(!hasNext()) throw new RuntimeException("No such element");

        List<T> valuesToReturn = new ArrayList<>();

        for(int i = 0; i < chunkSize && basicIterator.hasNext(); i++){
            valuesToReturn.add(basicIterator.next());
        }

        return valuesToReturn;
    }
}
