package org.cp.LLD.cursorPagination.entity;

import java.util.List;
import java.util.function.Predicate;

public class Filter<T> {
    FilterType filterType;
    List<Predicate<T>> filters;

    public Filter(FilterType filterType, List<Predicate<T>> filters) {
        this.filterType = filterType;
        this.filters = filters;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public List<Predicate<T>> getFilters() {
        return filters;
    }
}
