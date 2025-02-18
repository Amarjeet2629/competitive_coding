package org.cp.LLD.vendingMachine;

import org.cp.LLD.vendingMachine.entity.Coin;

public class Main {
    public static void main(String... args){
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.printInventory();

        //press insert coin
        vendingMachine.getVendingMachineState().insertCoin(vendingMachine);
        //insert count one by one
        vendingMachine.getVendingMachineState().addCoin(vendingMachine, Coin.FIVE);
        vendingMachine.getVendingMachineState().addCoin(vendingMachine, Coin.FIVE);
        vendingMachine.getVendingMachineState().addCoin(vendingMachine, Coin.FIVE);
        //move to product selection
        vendingMachine.getVendingMachineState().moveToProductSelection(vendingMachine);
        //select product
        vendingMachine.getVendingMachineState().selectProduct(vendingMachine, 301);
    }
}
