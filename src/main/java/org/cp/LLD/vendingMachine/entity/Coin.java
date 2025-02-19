package org.cp.LLD.vendingMachine.entity;

public enum Coin {
    FIVE(5),
    ONE(1),
    TEN(10);

    int val;

    Coin(int val){
        this.val = val;
    }

    public int getValue(){
        return val;
    }


}
