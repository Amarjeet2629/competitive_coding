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
        return start <= end;
    }

    @Override
    public Integer next() {
        Integer value = start;
        start += step;
        return value;
    }
}
