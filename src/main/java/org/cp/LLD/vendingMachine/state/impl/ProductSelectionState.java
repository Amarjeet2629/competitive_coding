package org.cp.LLD.vendingMachine.state.impl;

import org.cp.LLD.vendingMachine.VendingMachine;
import org.cp.LLD.vendingMachine.entity.Coin;
import org.cp.LLD.vendingMachine.entity.Item;
import org.cp.LLD.vendingMachine.state.IState;

import java.util.List;

public class ProductSelectionState implements IState {
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
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
        Item item = vendingMachine.getInventory().getItem(code);
        List<Coin> coinList = vendingMachine.getCoinList();

        if(item == null){
            cancelProductSelection(vendingMachine);
        }

        int sum = 0;
        for(int i = 0; i < coinList.size(); i++){
            sum += coinList.get(i).getValue();
        }

        if(sum < item.getPrice()){
            insufficientBalance(vendingMachine);
        } else {
            dispenseChange(vendingMachine, item);
        }
    }

    @Override
    public void insufficientBalance(VendingMachine vendingMachine) {
        System.out.println("Insufficient funds");
        List<Coin> coinList = vendingMachine.getCoinList();

        for(int i = 0; i  < coinList.size(); i++){
            System.out.println("Returning coin: " + coinList.get(i).getValue());
        }

        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }

    @Override
    public void cancelProductSelection(VendingMachine vendingMachine) {
        System.out.println("Cancelling Product selection");
        List<Coin> coinList = vendingMachine.getCoinList();

        for(int i = 0; i  < coinList.size(); i++){
            System.out.println("Returning coin: " + coinList.get(i).getValue());
        }

        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    }


    @Override
    public void dispenseChange(VendingMachine vendingMachine, Item item) {
        int sum = 0;
        for(int i = 0; i < vendingMachine.getCoinList().size(); i++){
            sum += vendingMachine.getCoinList().get(i).getValue();
        }

        int changeToReturn = sum - item.getPrice();
        if(changeToReturn > 0){
            System.out.println("Returning change: " + changeToReturn);
        }

        vendingMachine.setVendingMachineState(new DispenseProductState(vendingMachine, item));
    }

    @Override
    public void dispenseProduct(VendingMachine machine, Item item) {
        throw new RuntimeException("Operation Not supported");
    }
}
