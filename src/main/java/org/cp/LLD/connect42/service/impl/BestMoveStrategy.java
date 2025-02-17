package org.cp.LLD.connect42.service.impl;

import org.cp.LLD.connect42.entity.GameBoard;
import org.cp.LLD.connect42.entity.Piece;
import org.cp.LLD.connect42.service.IBestMoveStrategy;
import org.cp.LLD.connect42.service.IWinningStrategy;
import org.cp.LLD.connect42.service.PieceFactory;

import java.util.List;

public class BestMoveStrategy implements IBestMoveStrategy {
    List<IWinningStrategy> winningStrategies;

    public BestMoveStrategy(List<IWinningStrategy> winningStrategies){
        this.winningStrategies = winningStrategies;
    }

    @Override
    public int bestMove(GameBoard gameBoard, Piece piece) {
        Piece[][] board = gameBoard.getBoard();
        int m = board.length;
        int n = board[0].length;

        final int[] maxi = {0};
        final int[] col = {0};

        for(int i = 0; i < n; i++){
            for(int j = m - 1; j>= 0; j--){
                if(board[j][i].getPieceType().equals(PieceFactory.getPiece("-"))){
                    int finalI = i;
                    int finalJ = j;
                    winningStrategies.stream().forEach(winningStrategy -> {
                        int cnt = winningStrategy.checkWin(gameBoard, piece, finalJ, finalI);

                        if(cnt >= maxi[0]){
                            maxi[0] = cnt;
                            col[0] = finalI;
                        }
                    });
                    break;
                }
            }
        }

        return col[0];
    }


}
