package org.cp.LLD.connect4.service;

import org.cp.LLD.connect4.entity.Board;
import org.cp.LLD.connect4.entity.Piece;
import org.cp.LLD.connect4.entity.Player;
import org.cp.LLD.connect4.entity.Slot;

import java.util.*;

public class GameManager {
    private Board board;
    private Queue<Player> players;

    public GameManager(int m, int n){
       initializeGame(m, n);
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
            System.out.println("Player: " + player.getId() + " please select a slot to proceed.");

            int column = scanner.nextInt();

            if(column >= this.board.getGrid()[0].length){
                System.out.println("Please enter a valid columnId");
                continue;
            }

            int row = this.board.getFirstVacantSlotIndex(column);


            if(row == -1){
                System.out.println("This column is completely full select another column.");
                continue;
            }

            Slot slot = new Slot(row, column);

            if(!board.isSlotAvailable(slot)){
                System.out.println("Please select an empty slot.");
                continue;
            }

            player = players.poll();
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

        if(winner != null) {
            System.out.println("Winner is: Player " + winner.getId());
            printBoard();
        } else {
            System.out.println("No player was able to win the game");
        }
    }

    private boolean isGameCompleted(Slot slot, Piece piece){
            Piece[][] grid = this.board.getGrid();

            //check in horizontal direction
            for(int j = Math.max(0, slot.y - 3); j <= slot.y; j++){
                int cnt = 0;
                for(int i = j; i < Math.min(grid[0].length, j + 4); i++){
                    if(grid[slot.x][i] == piece){
                        cnt++;
                    }
                }

                if(cnt == 4) return true;
            }

            //check in vertical direction
            for(int i = Math.max(0, slot.x - 3); i <= slot.x; i++){
                int cnt = 0;
                for(int j = i; j < Math.min(grid.length, i + 4); j++){
                    if(grid[j][slot.y] == piece){
                        cnt++;
                    }
                }

                if(cnt == 4) return true;
            }

            //check along major diagonal
            int diff = Math.min(Math.min(slot.x, slot.y), 3);
            for(int i = slot.x - diff, j = slot.y - diff;
                i <= slot.x && j <= slot.y;
                i++, j++){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    if(i + k >= grid.length ||  j + k >= grid[0].length) continue;
                    if(grid[i + k][j + k] == piece) cnt++;
                }

                if(cnt == 4) return true;
            }


            //check minor diagonal
            diff = Math.min(Math.min(slot.y, grid.length - slot.x - 1), 3);

            for(int i = slot.x + diff, j = slot.y - diff; i >= slot.x && j <= slot.y; i--,j++){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    if(i - k < 0 || j + k >= grid[0].length) continue;
                    if(grid[i - k][j + k] == piece) cnt++;
                }

                if(cnt == 4) return true;
            }

            return false;
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
