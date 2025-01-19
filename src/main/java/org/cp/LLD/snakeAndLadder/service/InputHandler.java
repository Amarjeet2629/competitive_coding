package org.cp.LLD.snakeAndLadder.service;

import org.cp.LLD.snakeAndLadder.entity.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;
    List<Portal> portalList;
    LinkedList<Player> playersList;
    int boardSize;

    public InputHandler(){
        scanner = new Scanner(System.in);
        portalList = new ArrayList<>();
        playersList = new LinkedList<>();
    }

    private void generateSnakes(int numOfSnakes){
        for(int i = 0; i < numOfSnakes; i++){
            int start  = scanner.nextInt();
            int end = scanner.nextInt();

            Portal snakePortal = new SnakePortal(
                    new Position((start - 1) / boardSize, (start - 1) % boardSize),
                    new Position((end - 1) / boardSize, (end - 1) % boardSize)
            );

            portalList.add(snakePortal);
        }
    }

    private void generateLadders(int numOfLadders){
        for(int i = 0; i < numOfLadders; i++){
            int start  = scanner.nextInt();
            int end = scanner.nextInt();

            Portal ladderPortal = new LadderPortal(
                    new Position((start - 1) / boardSize, (start - 1) % boardSize),
                    new Position((end - 1) / boardSize, (end - 1) % boardSize)
            );

            portalList.add(ladderPortal);
        }
    }

    public void handleInput(){
        boardSize = scanner.nextInt();
        //generate snakes
        int numOfSnakes = scanner.nextInt();
        generateSnakes(numOfSnakes);
        //generate ladders
        int numOfLadders = scanner.nextInt();
        generateLadders(numOfLadders);
        //Generate players
        int numOfPlayer = scanner.nextInt();
        for(int i = 0; i < numOfPlayer; i++){
            String name = scanner.next();
            playersList.add(new Player(i + 1, name));
        }
    }


    public List<Portal> getPortalList() {
        return portalList;
    }

    public LinkedList<Player> getPlayersList() {
        return playersList;
    }

    public int getBoardSize(){
        return this.boardSize;
    }
}
