package org.cp.LLD.connect42.entity;

import org.cp.LLD.connect42.service.PieceFactory;

public class GameBoard {
    Piece[][] board;
    int row;
    int col;

    public GameBoard(int row, int col){
        this.row = row;
        this.col = col;
        initialize();
    }

    private void initialize(){
        board = new Piece[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = PieceFactory.getPiece("-");
            }
        }
    }

    public boolean isSlotAvailable(int col){
        return board[0][col].equals(PieceFactory.getPiece("-"));
    }

    public int  addPiece(Piece piece, int col){
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col].equals(PieceFactory.getPiece("-"))){
                board[i][col] = piece;
                return i;
            }
        }

        return -1;
    }

    public boolean isAnyMoveAvailable(){
        for(int i = 0 ; i < board[0].length; i++){
            if(board[0][i].equals(PieceFactory.getPiece("-"))){
                return true;
            }
        }

        return false;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
