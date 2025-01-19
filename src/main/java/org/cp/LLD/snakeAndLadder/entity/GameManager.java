package org.cp.LLD.snakeAndLadder.entity;

import org.cp.LLD.snakeAndLadder.service.InputHandler;

public class GameManager {
    InputHandler inputHandler;

    public GameManager(){
        this.inputHandler = new InputHandler();
    }
}
