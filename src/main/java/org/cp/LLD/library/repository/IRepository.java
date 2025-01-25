package org.cp.LLD.library.repository;

import java.util.List;

public interface IRepository <T, V>{
    public void add(T data);
    public T getById(V id);
    public void update(T data);
    public List<T> getAll();
    public void delete(T data);
}
