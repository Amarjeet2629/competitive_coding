package org.cp.LLD.connect42.service;

import org.cp.LLD.connect42.entity.GameBoard;
import org.cp.LLD.connect42.entity.Piece;
import org.cp.LLD.connect42.entity.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    GameBoard gameBoard;
    Queue<Player> players;
    Scanner scanner = new Scanner(System.in);
    List<IWinningStrategy> winningStrategies;
    IBestMoveStrategy bestMoveStrategy;

    public Game(int row, int col, LinkedList<Player> players, List<IWinningStrategy> winningStrategy, IBestMoveStrategy bestMoveStrategy){
        gameBoard = new GameBoard(row, col);
        this.players = players;
        this.winningStrategies = winningStrategy;
        this.bestMoveStrategy = bestMoveStrategy;
    }

    public void beginGame(){
        Player winner = null;
        boolean isGameOver = false;

        while(!isGameOver){
            Player player = players.peek();
            printBoard();

            if(player.isAI()){
                System.out.println("AI is playing");
                player = players.poll();
                int bestMoveColumn = bestMoveStrategy.bestMove(gameBoard, player.getPiece());
                int row = gameBoard.addPiece(player.getPiece(), bestMoveColumn);
                players.add(player);

                if(isPlayerWinner(gameBoard, row, bestMoveColumn, player.getPiece())){
                    isGameOver = true;
                    winner = player;
                    break;
                }

                continue;
            }

            System.out.println(player.getName() + ", please select a column to continue.");
            Integer col = scanner.nextInt();
            if(!gameBoard.isSlotAvailable(col)){
                continue;
            }

            players.poll();
            int row = gameBoard.addPiece(player.getPiece(), col);

            if(!gameBoard.isAnyMoveAvailable()){
                isGameOver = true;
                break;
            }

            final Player iPlayer = player;
            if(winningStrategies.stream()
                    .anyMatch(winningStrategy ->
                            winningStrategy
                                    .checkWin(gameBoard,
                                            iPlayer.getPiece(),
                                            row, col) == 4)){
                winner = player;
                isGameOver = true;
            }
            players.add(player);
        }

        if(winner != null){
            printBoard();
            System.out.println("Winner is: " + winner.getName());
        } else {
            System.out.println("Game was tie !!!");
        }
    }

    private boolean isPlayerWinner(GameBoard gameBoard, int row, int col, Piece piece){
        return winningStrategies.stream()
                .anyMatch(winningStrategy ->
                        winningStrategy
                                .checkWin(gameBoard,
                                        piece,
                                        row, col) == 4);
    }

    private void printBoard(){
        Piece[][] board = gameBoard.getBoard();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j].getPieceType() + " | ");
            }
            System.out.println();
        }
    }
}
