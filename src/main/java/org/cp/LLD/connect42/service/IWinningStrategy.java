package org.cp.LLD.connect42.service;

import org.cp.LLD.connect42.entity.GameBoard;
import org.cp.LLD.connect42.entity.Piece;

public interface IWinningStrategy {
    public int checkWin(GameBoard board, Piece piece, int row, int col);
}
