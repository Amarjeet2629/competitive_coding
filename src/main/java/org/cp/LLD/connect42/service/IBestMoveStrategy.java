package org.cp.LLD.connect42.service;

import org.cp.LLD.connect42.entity.GameBoard;
import org.cp.LLD.connect42.entity.Piece;

public interface IBestMoveStrategy {
    public int bestMove(GameBoard gameBoard, Piece piece);
}
