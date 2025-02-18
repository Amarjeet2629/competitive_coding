package org.cp.LLD.vendingMachine;

import org.cp.LLD.vendingMachine.entity.Coin;
import org.cp.LLD.vendingMachine.state.IState;
import org.cp.LLD.vendingMachine.state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    IState vendingMachineState;
    List<Coin> coinList;
    Inventory inventory;

    public VendingMachine(){
        this.vendingMachineState = new IdleState();
        this.coinList = new ArrayList<>();
        this.inventory = new Inventory(3);
    }

    public IState getVendingMachineState(){
        return vendingMachineState;
    }

    public void setVendingMachineState(IState vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }

    public void addCoin(Coin coin){
        this.coinList.add(coin);
    }

    public void setCoinList(List<Coin> coinList){
        this.coinList = coinList;
    }

    public List<Coin> getCoinList(){
        return this.coinList;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void printInventory(){
        for(int i = 0; i < this.inventory.getItems().length; i++){
            for(int j = 0; j < this.inventory.getItems()[0].length; j++){
                System.out.print(this.inventory.getItems()[i][j].getCode() + " ");
            }
            System.out.println();
        }
    }

}
