package org.cp.LLD.connect42.service.impl;

import org.cp.LLD.connect42.entity.GameBoard;
import org.cp.LLD.connect42.entity.Piece;
import org.cp.LLD.connect42.service.IWinningStrategy;

public class HorizontalWinningStrategy implements IWinningStrategy {
    @Override
    public int checkWin(GameBoard gameBoard, Piece piece, int row, int col) {
        Piece[][] board = gameBoard.getBoard();
        int n = board[0].length;
        int maxConsecutive = 0;

        for(int i = Math.max(0, col - 3); i <= col; i++){
            int cnt = 0;
            for(int j = i; j <= Math.min(n - 1, i + 3); j++){
                if(board[row][j].equals(piece)){
                    cnt += 1;
                }
            }

            maxConsecutive = Math.max(maxConsecutive, cnt);
        }

        return maxConsecutive;
    }
}
