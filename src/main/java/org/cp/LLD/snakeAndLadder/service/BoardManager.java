package org.cp.LLD.snakeAndLadder.service;

import org.cp.LLD.snakeAndLadder.entity.Portal;
import org.cp.LLD.snakeAndLadder.entity.Position;
import org.cp.LLD.snakeAndLadder.entity.Slot;

import java.util.List;

public class BoardManager {
    private final Slot[][] board;
    private final int size;

    public BoardManager(int n, List<Portal> portalList){
        board = new Slot[n][n];
        size = n;
        initialize(portalList);
    }

    private void initialize(List<Portal> portalList){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new Slot(new Position(i, j), null);
            }
        }

        for(Portal portal: portalList){
            Position startPosition = portal.getStartPosition();
            int i = startPosition.getX();
            int j = startPosition.getY();
            board[i][j].setPortal(portal);
        }
    }

    public Position getFinalPosition(Position position){
        if(board[position.getX()][position.getY()].getPortal() == null) return position;
        Portal portal = board[position.getX()][position.getY()].getPortal();

        return getFinalPosition(portal.getEndPosition());
    }

}
