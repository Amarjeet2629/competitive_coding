package org.cp.LLD.iterator;

import java.util.List;
import java.util.function.Predicate;

public class FilterableIterator<T> implements Iterator<T> {
    private final List<T> collections;
    private final Predicate<T> filter;
    private int index = 0;

    FilterableIterator(List<T> collections, Predicate<T> filter){
        this.filter = filter;
        this.collections = collections;
        advance();
    }

    private void advance(){
        while (hasNext() && !filter.test(collections.get(index))){
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index != collections.size();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new RuntimeException("No such element");

        T value = collections.get(index);
        index++;
        advance();

        return value;
    }
}
