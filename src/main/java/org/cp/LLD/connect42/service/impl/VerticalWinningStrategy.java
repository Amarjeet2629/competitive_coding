package org.cp.LLD.connect42.service.impl;

import org.cp.LLD.connect42.entity.GameBoard;
import org.cp.LLD.connect42.entity.Piece;
import org.cp.LLD.connect42.service.IWinningStrategy;

public class VerticalWinningStrategy implements IWinningStrategy {

    @Override
    public int checkWin(GameBoard gameBoard, Piece piece, int row, int col) {
        Piece[][] board = gameBoard.getBoard();
        int m = board.length;
        int maxConsecutive = 0;

        for(int i = Math.max(0, row - 3); i <= row; i++){
            int cnt = 0;
            for(int j = i; j <= Math.min(m - 1, i + 3); j++){
                if(board[j][col].equals(piece)) {
                    cnt += 1;
                }
            }

            maxConsecutive = Math.max(maxConsecutive, cnt);
        }

        return maxConsecutive;
    }
}
