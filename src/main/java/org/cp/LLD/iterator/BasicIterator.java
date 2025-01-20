package org.cp.LLD.iterator;

import java.util.List;

public class BasicIterator<T> implements Iterator<T>{
    List<T> valuesToIterate;
    int index = 0;

    public BasicIterator(List<T> valuesToIterate){
        this.valuesToIterate  = valuesToIterate;
    }

    @Override
    public boolean hasNext() {
        return index < valuesToIterate.size();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new  RuntimeException("No Such Element");
        index++;
        return valuesToIterate.get(index - 1);
    }
}
