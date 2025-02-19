package org.cp.LLD.vendingMachine;

import org.cp.LLD.vendingMachine.entity.Item;


public class Inventory {
    Item[][] items;

    public Inventory(int n){
        initialize(n);
    }

    private void initialize(int n){
        items = new Item[n][n];

        items[0][0] =  new Item(101, "Coke", 20);
        items[0][1] =  new Item(102, "Pepsi", 30);
        items[0][2] =  new Item(103, "Fruit", 10);

        items[1][0] = new Item(201, "Marie", 10);
        items[1][1] = new Item(202, "Oreo", 12);
        items[1][2] = new Item(203, "ParleG", 15);

        items[2][0] = new Item(301, "DairyMilk", 10);
        items[2][1] = new Item(302, "Perk", 5);
        items[2][2] = new Item(303, "coffee", 3);
    }

    public Item getItem(int code){
        int m = items.length;
        int n = items[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(items[i][j] != null && items[i][j].getCode() == code) return items[i][j];
            }
        }

        return null;
    }

    public void markItemUnavailable(Item item){
        int m = items.length;
        int n = items[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(items[i][j].getCode() == item.getCode()){
                    items[i][j] = null;
                }
            }
        }
    }

    public Item[][] getItems(){
        return this.items;
    }
}
