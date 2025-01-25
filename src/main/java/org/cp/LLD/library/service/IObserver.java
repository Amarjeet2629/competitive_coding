package org.cp.LLD.library.service;

import org.cp.LLD.library.models.Book;

public interface IObserver {
    public void emitFilterResult(Book book);
    public void invalidSearch(String message);
    public void informationMessage(String message);
}
