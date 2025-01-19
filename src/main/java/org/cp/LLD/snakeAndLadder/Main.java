package org.cp.LLD.snakeAndLadder;

import org.cp.LLD.snakeAndLadder.entity.Dice;
import org.cp.LLD.snakeAndLadder.service.BoardManager;
import org.cp.LLD.snakeAndLadder.service.GameManager;
import org.cp.LLD.snakeAndLadder.service.InputHandler;

public class Main {
    public static void main(String ...args){
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput();

        GameManager gameManager = new GameManager(
                inputHandler.getPlayersList(),
                new BoardManager(inputHandler.getBoardSize(), inputHandler.getPortalList()),
                new Dice(6),
                inputHandler.getBoardSize());

        gameManager.beginGame();
    }
}
