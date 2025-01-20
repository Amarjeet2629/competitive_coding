package org.cp.LLD.cursorPagination.repository;

import java.util.List;

public interface IRepository<T> {
    public void addData(T data);
    public void updateDate(T data);
    public T findById(int id);
    public List<T> getAllData();
    public List<T> getDataAfterCursor(Long cursor, int limit);
}
