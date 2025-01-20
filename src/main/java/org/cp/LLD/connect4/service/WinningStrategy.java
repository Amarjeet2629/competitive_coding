package org.cp.LLD.connect4.service;

import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Slot;

public interface WinningStrategy {
    public boolean accept(Piece[][] board, Piece piece, Slot slot);
}
