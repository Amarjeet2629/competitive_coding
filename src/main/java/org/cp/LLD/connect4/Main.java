package org.cp.LLD.connect4;

import org.cp.LLD.connect4.service.GameManager;

public class Main {
    public static void main(String ...args){
        GameManager gameManager = new GameManager(4, 4);
        gameManager.beginGame();

    }
}
