package org.cp.LLD.connect4.service;

import org.cp.LLD.connect4.entity.Board;
import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Player;
import org.cp.LLD.connect4.entity.Slot;

import java.util.*;

public class GameManager {
    private Board board;
    private Queue<Player> players;
    private final List<WinningStrategy> winningStrategyList;
    private final IObservable gameEventNotifier;

    public GameManager(int m, int n, List<WinningStrategy> winningStrategyList, IObservable gameEventNotifier){
       initializeGame(m, n);
       this.winningStrategyList = winningStrategyList;
       this.gameEventNotifier = gameEventNotifier;
    }

    private void initializeGame(int m, int n){
        board = new Board(m, n);
        Player player1 = new Player(1, "Amarjeet", Piece.O);
        Player player2 = new Player(2, "Prachi", Piece.X);

        players = new LinkedList<>(
                Arrays.asList(player1, player2)
        );
    }

    public void beginGame(){
        boolean isGameOver = false;
        Player winner = null;

        while(!isGameOver){
            printBoard();
            Scanner scanner = new Scanner(System.in);
            Player player = players.peek();

            this.gameEventNotifier.notifyGameEvent("Player: " + player.getId() + " please select a slot to proceed.");
            int column = scanner.nextInt();

            if(column >= this.board.getGrid()[0].length){
                gameEventNotifier.notifyGameEvent("Please enter a valid columnId");
                continue;
            }

            int row = this.board.getFirstVacantSlotIndex(column);

            if(row == -1){
                gameEventNotifier.notifyGameEvent("This column is completely full select another column.");
                continue;
            }

            Slot slot = new Slot(row, column);

            if(!board.isSlotAvailable(slot)){
                gameEventNotifier.notifyGameEvent("Please select an empty slot.");
                continue;
            }

            player = players.poll();
            assert player != null;
            board.addPiece(player.getPiece(), slot);

            if(isGameCompleted(slot, player.getPiece())){
                winner = player;
                printBoard();
                break;
            }

            if(!this.board.isFreeCellAvailable()){
                isGameOver = true;
            }

            players.add(player);
        }

        gameEventNotifier.notifyGameEnd(winner);
    }

    private boolean isGameCompleted(Slot slot, Piece piece){
        return winningStrategyList.stream().anyMatch(winningStrategy -> winningStrategy.accept(board.getGrid(), piece, slot));
    }


    private void printBoard(){
        Piece[][] grid = this.board.getGrid();
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }

    }



}
