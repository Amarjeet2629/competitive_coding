package org.cp.LLD.vendingMachine.state.impl;

import org.cp.LLD.vendingMachine.VendingMachine;
import org.cp.LLD.vendingMachine.entity.Coin;
import org.cp.LLD.vendingMachine.entity.Item;
import org.cp.LLD.vendingMachine.state.IState;

import java.util.ArrayList;

public class IdleState implements IState {
    public IdleState(){}

    public IdleState(VendingMachine vendingMachine){
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new InsertCoinState());
    }

    @Override
    public void addCoin(VendingMachine vendingMachine, Coin coin) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void cancelInsertCoin(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void moveToProductSelection(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int code) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void cancelProductSelection(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void dispenseChange(VendingMachine machine, Item item) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, Item item) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void insufficientBalance(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
    }
}
