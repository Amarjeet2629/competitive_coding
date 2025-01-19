package org.cp.LLD.ticTacToe;

import org.cp.LLD.ticTacToe.entity.*;
import org.cp.LLD.ticTacToe.service.GameManager;
import org.cp.LLD.ticTacToe.service.PieceFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String ...args){
        Scanner scanner = new Scanner(System.in);
        String firstPlayerPieceType = scanner.next();
        String firstPlayerName = scanner.next();

        String secondPlayerPieceType = scanner.next();
        String secondPlayerName = scanner.next();

        Player player1 = new Player(firstPlayerName, PieceFactory.getPiece(firstPlayerPieceType));
        Player player2 = new Player(secondPlayerName, PieceFactory.getPiece(secondPlayerPieceType));

        Queue<Player> players = new LinkedList<>();

        players.add(player1);
        players.add(player2);

        IObservable gameEventNotifier = new GameEventNotifier();
        IObserver UiLogger = new UILogger();

        gameEventNotifier.addObserver(UiLogger);


        GameManager gameManager = new GameManager(players, gameEventNotifier);
        gameManager.startGame();
    }
}
