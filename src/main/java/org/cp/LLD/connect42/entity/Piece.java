package org.cp.LLD.connect42.entity;

import java.util.Objects;

public abstract class Piece {
    String pieceType;

    public Piece(String pieceType){
        this.pieceType = pieceType;
    }

    public String getPieceType(){
        return pieceType;
    }

    public boolean equals(Object obj){
       if(obj == null || obj.getClass() != getClass()) return false;
       Piece piece = (Piece) obj;

       return piece.pieceType == pieceType;
    }

    public int hashCode(){
        return Objects.hash(pieceType);
    }
}
