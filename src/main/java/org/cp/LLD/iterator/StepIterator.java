package org.cp.LLD.iterator;

public class StepIterator implements Iterator<Integer>{
    int start;
    int end;
    int step;

    public StepIterator(int start, int end, int step){
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public boolean hasNext() {
        if(step < 0){
            return start >= end;
        }

        return start <= end;
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new RuntimeException("No such element");

        Integer value = start;
        start += step;
        return value;
    }
}
