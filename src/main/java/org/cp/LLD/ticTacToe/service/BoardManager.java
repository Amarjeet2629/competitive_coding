package org.cp.LLD.ticTacToe.service;

import org.cp.LLD.ticTacToe.entity.Piece;

public class BoardManager {
    private Piece[][] grid;

    public BoardManager(){
        grid = new Piece[3][3];
        initialize();
    }

    private void initialize(){
        Piece emptyPiece = PieceFactory.getPiece("-");

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                grid[i][j] = emptyPiece;
            }
        }
    }

    public Piece[][] getGrid() {
        return grid;
    }

    public boolean hasFreeCells(){
        Piece emptyPiece = PieceFactory.getPiece("-");

        for (Piece[] pieces : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (pieces[j].equals(emptyPiece)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isGameCompleted(){
        //check horizontally
        for(Piece[] pieces: grid){
            Piece pieceToMatch = pieces[0];
            int cnt = 0;
            for(int j = 0; j < 3; j++){
                if(pieces[j].equals(pieceToMatch) && !pieceToMatch.equals(PieceFactory.getPiece("-"))) cnt++;
            }

            if(cnt == 3) return true;
        }

        //check vertically
        for(int i = 0; i < 3; i++){
            Piece pieceToMatch = grid[0][i];
            int cnt = 0;
            for(int j = 0; j < 3; j++){
                if(grid[j][i].equals(pieceToMatch) && !pieceToMatch.equals(PieceFactory.getPiece("-"))){
                    cnt++;
                }
            }

            if(cnt == 3) return true;
        }

        //along  major diagnoal;
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && !grid[0][0].equals(PieceFactory.getPiece("-"))){
            return true;
        }

        //along minor diagnoal;
        if(grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && !grid[2][0].equals(PieceFactory.getPiece("-"))){
            return true;
        }

        return false;
    }

    public boolean isEmptySlot(int row, int col){
        return grid[row - 1][col - 1].equals(PieceFactory.getPiece("-"));
    }

    public void addPiece(int row, int col, Piece piece){
        grid[row - 1][col - 1] = piece;
    }
}
