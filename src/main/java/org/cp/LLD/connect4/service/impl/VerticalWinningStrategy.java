package org.cp.LLD.connect4.service.impl;

import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Slot;
import org.cp.LLD.connect4.service.WinningStrategy;

public class VerticalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Piece[][] board, Piece piece, Slot slot) {
        for(int i = Math.max(0, slot.x - 3); i <= slot.x; i++){
            int cnt = 0;
            for(int j = i; j < Math.min(board.length, i + 4); j++){
                if(board[j][slot.y] == piece){
                    cnt++;
                }
            }

            if(cnt == 4) return true;
        }

        return false;
    }
}
