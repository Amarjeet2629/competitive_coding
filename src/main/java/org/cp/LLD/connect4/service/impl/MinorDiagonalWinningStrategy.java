package org.cp.LLD.connect4.service.impl;

import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Slot;
import org.cp.LLD.connect4.service.WinningStrategy;

public class MinorDiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean accept(Piece[][] board, Piece piece, Slot slot) {
        int diff = Math.min(Math.min(slot.y, board.length - slot.x - 1), 3);

        for(int i = slot.x + diff, j = slot.y - diff; i >= slot.x && j <= slot.y; i--,j++){
            int cnt = 0;
            for(int k = 0; k < 4; k++){
                if(i - k < 0 || j + k >= board[0].length) continue;
                if(board[i - k][j + k] == piece) cnt++;
            }

            if(cnt == 4) return true;
        }

        return false;
    }
}
