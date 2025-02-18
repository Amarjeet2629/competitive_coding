package org.cp.LLD.vendingMachine.state;

import org.cp.LLD.vendingMachine.VendingMachine;
import org.cp.LLD.vendingMachine.entity.Coin;
import org.cp.LLD.vendingMachine.entity.Item;

public interface IState {
    public void insertCoin(VendingMachine vendingMachine);
    public void addCoin(VendingMachine vendingMachine, Coin coin);
    public void cancelInsertCoin(VendingMachine vendingMachine);
    public void moveToProductSelection(VendingMachine vendingMachine);
    public void selectProduct(VendingMachine vendingMachine, int code);
    public void cancelProductSelection(VendingMachine vendingMachine);
    public void dispenseChange(VendingMachine machine, Item item);
    public void dispenseProduct(VendingMachine machine, Item item);
    public void insufficientBalance(VendingMachine vendingMachine);
}
