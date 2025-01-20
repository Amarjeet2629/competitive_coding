package org.cp.LLD.cursorPagination.interfaces;

import org.cp.LLD.cursorPagination.entity.ResponseData;

public interface IPagination<T> {
    public ResponseData<T> fetchPage(int limit, Long cursor);
}
