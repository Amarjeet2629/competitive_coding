package org.cp.LLD.connect42.entity;

public class Player {
    String name;
    Piece piece;
    boolean isAI;

    public Player(String name, Piece piece, boolean isAI){
        this.name = name;
        this.piece = piece;
        this.isAI = isAI;
    }

    public String getName(){
        return name;
    }

    public Piece getPiece(){
        return piece;
    }

    public boolean isAI(){
        return this.isAI;
    }
}
