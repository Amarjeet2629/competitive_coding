package org.cp.LLD.fractionalKnapscak.models;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private int id;
    private int size;
    private double fee;
    private final List<Transaction> childTransaction  = new ArrayList<>();

    public Transaction(int id, int size, double fee){
        this.id = id;
        this.size = size;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public double getFee() {
        return fee;
    }

    public void addChildTransaction(Transaction transaction){
        this.childTransaction.add(transaction);
    }
    public List<Transaction> getChildTransaction(){
        return this.childTransaction;
    }
}
