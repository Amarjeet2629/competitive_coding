package org.cp.LLD.ticTacToe.entity;

public class Player {
    String name;
    Piece piece;

    public Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
}
