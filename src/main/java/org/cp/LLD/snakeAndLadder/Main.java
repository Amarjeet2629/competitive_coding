package org.cp.LLD.snakeAndLadder;

import org.cp.LLD.snakeAndLadder.entity.*;
import org.cp.LLD.snakeAndLadder.service.BoardManager;
import org.cp.LLD.snakeAndLadder.service.GameManager;
import org.cp.LLD.snakeAndLadder.service.InputHandler;

public class Main {
    public static void main(String ...args){
        InputHandler inputHandler = new InputHandler();
        inputHandler.handleInput();

        IObserver uiLogger = new UILogger();
        IObservable gameEventNotifier = new GameEventObservable();

        gameEventNotifier.addObserver(uiLogger);

        GameManager gameManager = new GameManager(
                inputHandler.getPlayersList(),
                new BoardManager(inputHandler.getBoardSize(), inputHandler.getPortalList()),
                new Dice(6),
                inputHandler.getBoardSize(),
                gameEventNotifier
        );

        gameManager.beginGame();
    }
}
