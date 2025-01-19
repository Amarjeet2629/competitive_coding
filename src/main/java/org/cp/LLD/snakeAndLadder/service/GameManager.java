package org.cp.LLD.snakeAndLadder.service;

import org.cp.LLD.snakeAndLadder.entity.IDice;
import org.cp.LLD.snakeAndLadder.entity.IObservable;
import org.cp.LLD.snakeAndLadder.entity.Player;
import org.cp.LLD.snakeAndLadder.entity.Position;

import java.util.Queue;

public class GameManager {
    Queue<Player> listOfPlayers;
    BoardManager boardManager;
    IDice dice;
    int boardSize;
    IObservable gameEventObservable;

    public GameManager(Queue<Player> listOfPlayers,
                       BoardManager boardManager,
                       IDice dice, int boardSize,
                       IObservable gameEventObservable){
        this.listOfPlayers = listOfPlayers;
        this.boardManager = boardManager;
        this.dice = dice;
        this.boardSize = boardSize;
        this.gameEventObservable = gameEventObservable;
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

            if(!boardManager.isValidMove(currentPosition + movesToMake)){
                gameEventObservable.notifyGameEvent(player, " rolled a " + movesToMake +
                        " and moved from " +
                        currentPosition + " to "
                        + (movesToMake + currentPosition) + ", Invalid Move.");
                continue;
            }

            int finalPosition = movesToMake + currentPosition;

            Position position = this.boardManager.getFinalPosition(
                    new Position((finalPosition - 1) / boardSize,
                             (finalPosition - 1) % boardSize)
            );

            finalPosition = position.getX() * boardSize + position.getY() + 1;
            gameEventObservable.notifyGameEvent(player, " rolled a " + movesToMake +  " and moved from " + currentPosition + " to " + finalPosition);
            player.setPosition(position);

            if(finalPosition == boardSize * boardSize){
                isGameOver = true;
                winner = player;
            }
        }

        gameEventObservable.notifyGameEnd(winner);
    }
}
