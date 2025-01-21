package org.cp.LLD.connect4.service.impl;

import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Slot;
import org.cp.LLD.connect4.service.WinningStrategy;

public class HorizontalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Piece[][] board, Piece piece, Slot slot) {
        for(int j = Math.max(0, slot.y - 3); j <= slot.y; j++){
            int cnt = 0;
            for(int i = j; i < Math.min(board[0].length, j + 4); i++){
                if(board[slot.x][i] == piece){
                    cnt++;
                }
            }

            if(cnt == 4) return true;
        }

        return false;
    }
}
