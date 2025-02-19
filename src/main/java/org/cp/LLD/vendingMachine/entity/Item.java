package org.cp.LLD.vendingMachine.entity;

public class Item {
    int code;
    String name;
    int price;

    public Item(int code, String name, int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
