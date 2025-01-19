package org.cp.LLD.ticTacToe.service;

import org.cp.LLD.ticTacToe.entity.IObservable;
import org.cp.LLD.ticTacToe.entity.Piece;
import org.cp.LLD.ticTacToe.entity.Player;

import java.util.Queue;
import java.util.Scanner;

public class GameManager {
    Queue<Player> players;
    BoardManager boardManager;
    Scanner scanner;
    IObservable gameEventNotifier;

    public GameManager(Queue<Player> players, IObservable gameEventNotifier){
        this.boardManager = new BoardManager();
        this.players = players;
        scanner = new Scanner(System.in);
        this.gameEventNotifier = gameEventNotifier;
    }

    public void startGame(){
        boolean isGameOver = false;
        Player winner = null;

        displayBoard();
        while(!isGameOver){
            Player player = players.peek();

            assert player != null;
            gameEventNotifier.notifyGameEvent(player.getName() + ", Please select a position to place your piece.");


            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean isInputValid = validateInput(row, col);

            if(!isInputValid){
                gameEventNotifier.notifyGameEvent("Input is not valid, Please try again.");
                continue;
            }

            boardManager.addPiece(row, col, player.getPiece());

            if(boardManager.isGameCompleted()){
                isGameOver = true;
                winner = player;
            }

            if(!isGameOver && !boardManager.hasFreeCells()){
                isGameOver = true;
            }

            player = players.poll();
            players.add(player);

            displayBoard();
        }

        gameEventNotifier.notifyGameEnd(winner);
    }

    private boolean validateInput(int row, int col){
        if(row < 0 || row > 3 || col < 0 || col > 3) return false;
        if(!boardManager.isEmptySlot(row, col)) return false;

        return true;
    }

    private void displayBoard(){
        Piece[][] grid = this.boardManager.getGrid();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }
    }
}
