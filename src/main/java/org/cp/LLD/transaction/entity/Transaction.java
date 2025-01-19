package org.cp.LLD.transaction.entity;

public class Transaction {
    String id;
    int size;
    int fee;

    public Transaction(String id, int size, int fee){
        this.id = id;
        this.size = size;
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getFee() {
        return fee;
    }
}
