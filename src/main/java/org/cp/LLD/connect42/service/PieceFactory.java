package org.cp.LLD.connect42.service;

import org.cp.LLD.connect42.entity.EmptyPiece;
import org.cp.LLD.connect42.entity.OPiece;
import org.cp.LLD.connect42.entity.Piece;
import org.cp.LLD.connect42.entity.XPiece;

public class PieceFactory {
    public static Piece getPiece(String piece){
        switch (piece){
            case "X":{
                return new XPiece(piece);
            }

            case "O":{
                return new OPiece(piece);
            }

            case "-":{
                return new EmptyPiece(piece);
            }

            default:
                return null;
        }
    }
}
