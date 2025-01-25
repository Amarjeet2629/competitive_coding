package org.cp.LLD.connect4.entity;


import java.util.HashMap;

public class Board {
    private final Piece[][] grid;
    private HashMap<Integer, Integer> firstAvailableSlotByColumns;

    public Board(int m, int n){
       grid = new Piece[m][n];
       firstAvailableSlotByColumns = new HashMap<>();

       for(int i = 0; i < n; i++){
           firstAvailableSlotByColumns.put(i, m - 1);
       }
    }

    public Piece[][] getGrid(){
        return this.grid;
    }

    public void addPiece(Piece piece, Slot slot){
        grid[slot.x][slot.y] = piece;
        firstAvailableSlotByColumns.put(slot.y, slot.x - 1);
    }


    public boolean isFreeCellAvailable(){
        for(Integer row: firstAvailableSlotByColumns.values()){
            if(row != -1) return true;
        }
        return false;
    }


    public int getFirstVacantSlotIndex(int column){
        return firstAvailableSlotByColumns.get(column);
    }

}
