package org.cp.LLD.ticTacToe.entity;

import java.util.Objects;

public abstract class Piece {
    String pieceType;

    public Piece(String pieceType){
        this.pieceType = pieceType;
    }

    @Override
    public String toString(){
        return this.pieceType;
    }

    @Override
    public boolean equals(Object object){
        if(object == null || object.getClass() != getClass()) return false;

        return Objects.equals(((Piece) object).pieceType, pieceType);
    }

    @Override
    public int hashCode(){
        return Objects.hash(pieceType);
    }
}
