package org.cp.LLD.ticTacToe.service;

import org.cp.LLD.ticTacToe.entity.EmptyPiece;
import org.cp.LLD.ticTacToe.entity.OPiece;
import org.cp.LLD.ticTacToe.entity.Piece;
import org.cp.LLD.ticTacToe.entity.XPiece;

public class PieceFactory {
    public static Piece getPiece(String pieceType){
        switch (pieceType){
            case "X":
                return new XPiece(pieceType);
            case "O":
                return new OPiece(pieceType);
            default:
                return new EmptyPiece("-");
        }
    }
}
