package org.cp.LLD.cursorPagination.entity;

import java.util.List;

public class ResponseData <T>{
    private List<T> data;
    private final Long cursor;
    private final boolean hasMore;
    private final Long backCursor;
    //More fields can be added if we need to modify the response data

    public ResponseData(List<T> data, Long cursor, boolean hasMore, Long backCursor){
        this.data = data;
        this.cursor = cursor;
        this.hasMore = hasMore;
        this.backCursor = backCursor;
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

    public void setData(List<T> data){
        this.data = data;
    }

    public Long getBackCursor(){
        return this.backCursor;
    }


}
