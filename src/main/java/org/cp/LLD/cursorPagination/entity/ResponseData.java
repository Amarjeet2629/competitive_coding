package org.cp.LLD.cursorPagination.entity;

import java.util.List;

public class ResponseData <T>{
    private final List<T> data;
    private final Long cursor;
    private final boolean hasMore;
    //More fields can be added if we need to modify the response data

    public ResponseData(List<T> data, Long cursor, boolean hasMore){
        this.data = data;
        this.cursor = cursor;
        this.hasMore = hasMore;
    }

    public Long getCursor(){
        return this.cursor;
    }

    public List<T> getData(){
        return this.data;
    }

    public boolean isHasMore(){
        return this.hasMore;
    }


}
