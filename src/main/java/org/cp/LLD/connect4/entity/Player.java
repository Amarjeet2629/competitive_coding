package org.cp.LLD.connect4.entity;

public class Player {
    int id;
    String name;
    Piece piece;

    public Player(int id, String name, Piece piece){
        this.id = id;
        this.name = name;
        this.piece = piece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
}
