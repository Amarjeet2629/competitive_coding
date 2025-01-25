package org.cp.LLD.iterator;

import java.util.ArrayList;
import java.util.List;

/*
This implementation is not correct;
 */
public class ChunkedIterator<T> {
    private final Iterator<T> basicIterator;
    private final int chunk;
    private final List<T> collections;
    private int index = 0;

    public ChunkedIterator(List<T> collections, int chunk){
        this.basicIterator = new BasicIterator<>(collections);
        this.collections = collections;
        this.chunk = chunk;
    }

    public boolean hasNext(){
        return index != collections.size();
    }

    public List<T> next(){
        if(!hasNext()) throw new RuntimeException("No such element");
        List<T> values = new ArrayList<>();

        while(hasNext() && values.size() < chunk){
            values.add(collections.get(index));
            index++;
        }

        return values;
    }
}
