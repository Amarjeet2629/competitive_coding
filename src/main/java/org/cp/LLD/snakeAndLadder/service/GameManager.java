package org.cp.LLD.snakeAndLadder.service;

import org.cp.LLD.snakeAndLadder.entity.Dice;
import org.cp.LLD.snakeAndLadder.entity.IDice;
import org.cp.LLD.snakeAndLadder.entity.Player;
import org.cp.LLD.snakeAndLadder.entity.Position;

import java.util.Queue;

public class GameManager {
    Queue<Player> listOfPlayers;
    BoardManager boardManager;
    IDice dice;
    int boardSize;

    public GameManager(Queue<Player> listOfPlayers, BoardManager boardManager, IDice dice, int boardSize){

        this.listOfPlayers = listOfPlayers;
        this.boardManager = boardManager;
        this.dice = dice;
        this.boardSize = boardSize;

        beginGame();
    }

    public void beginGame(){
        boolean isGameOver = false;
        Player winner = null;

        while(!isGameOver){
            Player player = listOfPlayers.poll();
            listOfPlayers.add(player);
            assert player != null;
            int currentPosition = player.getPosition().getX() * boardSize + player.getPosition().getY() + 1;

            //roll the dice
            int movesToMake = dice.rollDice();

            if(boardManager.isValidMove(currentPosition + movesToMake)){
                System.out.println(player.getName() + " rolled a " + movesToMake +  " and moved from " + currentPosition + " to " + movesToMake + currentPosition + ", Invalid Move.");
                continue;
            }

            int finalPosition = movesToMake + currentPosition;

            Position position = this.boardManager.getFinalPosition(
                    new Position((finalPosition - 1) / boardSize,
                             (finalPosition - 1) % boardSize)
            );

            finalPosition = position.getX() * boardSize + position.getY() + 1;

            System.out.println(player.getName() + " rolled a " + movesToMake +  " and moved from " + currentPosition + " to " + finalPosition);

            player.setPosition(position);

            if(finalPosition == 100){
                isGameOver = true;
                winner = player;
            }
        }

        System.out.println("Winner is " + winner.getName());
    }
}
