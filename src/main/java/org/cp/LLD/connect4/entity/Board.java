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

    public boolean isSlotAvailable(Slot slot){
        return grid[slot.x][slot.y] == null;
    }

    public boolean isFreeCellAvailable(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == null) return true;
            }
        }

        return false;
    }


    public int getFirstVacantSlotIndex(int column){
        return firstAvailableSlotByColumns.get(column);
    }

}
