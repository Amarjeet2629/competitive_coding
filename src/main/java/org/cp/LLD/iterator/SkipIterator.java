package org.cp.LLD.iterator;

import java.util.ArrayList;
import java.util.List;

public class SkipIterator<T> implements Iterator<T>{
    private final List<T> collections = new ArrayList<>();
    private final int skip;
    private int index = 0;

    public SkipIterator(List<T> collections, int skip){
        this.collections.addAll(collections);
        this.skip = skip;
    }

    private void advance(){
        for(int i = 0; i < skip; i++) index++;
    }

    @Override
    public boolean hasNext() {
       return index < collections.size();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No such method");
        T value = collections.get(index);
        advance();
        return value;
    }
}
