package org.cp.LLD.connect4.service.impl;

import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Slot;
import org.cp.LLD.connect4.service.WinningStrategy;

public class MajorDiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Piece[][] board, Piece piece, Slot slot) {
        int diff = Math.min(Math.min(slot.x, slot.y), 3);

        for(int i = slot.x - diff, j = slot.y - diff;
            i <= slot.x && j <= slot.y;
            i++, j++){
            int cnt = 0;
            for(int k = 0; k < 4; k++){
                if(i + k >= board.length ||  j + k >= board[0].length) continue;
                if(board[i + k][j + k] == piece) cnt++;
            }

            if(cnt == 4) return true;
        }

        return false;
    }
}
