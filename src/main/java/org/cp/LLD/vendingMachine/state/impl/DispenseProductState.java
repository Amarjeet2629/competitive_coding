package org.cp.LLD.vendingMachine.state.impl;

import org.cp.LLD.vendingMachine.VendingMachine;
import org.cp.LLD.vendingMachine.entity.Coin;
import org.cp.LLD.vendingMachine.entity.Item;
import org.cp.LLD.vendingMachine.state.IState;

public class DispenseProductState implements IState {
    public DispenseProductState(VendingMachine vendingMachine, Item item){
        dispenseProduct(vendingMachine, item);
    }

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
        System.out.println("Dispensing Product: " + item.getName());
        machine.getInventory().markItemUnavailable(item);
        machine.setVendingMachineState(new IdleState(machine));
    }

    @Override
    public void insufficientBalance(VendingMachine vendingMachine) {
        throw new RuntimeException("Operation Not supported");
    }
}
