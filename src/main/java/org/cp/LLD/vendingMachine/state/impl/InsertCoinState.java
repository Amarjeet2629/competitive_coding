package org.cp.LLD.vendingMachine.state.impl;

import org.cp.LLD.vendingMachine.VendingMachine;
import org.cp.LLD.vendingMachine.entity.Coin;
import org.cp.LLD.vendingMachine.entity.Item;
import org.cp.LLD.vendingMachine.state.IState;

import java.util.List;

public class InsertCoinState implements IState {
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
    }

    @Override
    public void addCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Added coin: " + coin.getValue());
        vendingMachine.addCoin(coin);
    }

    @Override
    public void cancelInsertCoin(VendingMachine vendingMachine) {
        System.out.println("Cancelling coin insert, returning balance amount");

        List<Coin> coinList = vendingMachine.getCoinList();
        for(int i = 0; i  < coinList.size(); i++){
            System.out.println("Returning coin: " + coinList.get(i));
        }

        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void moveToProductSelection(VendingMachine vendingMachine) {
        vendingMachine.setVendingMachineState(new ProductSelectionState());
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
