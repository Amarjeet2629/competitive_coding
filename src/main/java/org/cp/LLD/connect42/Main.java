package org.cp.LLD.connect42;

import org.cp.LLD.connect42.entity.Piece;
import org.cp.LLD.connect42.entity.Player;
import org.cp.LLD.connect42.service.Game;
import org.cp.LLD.connect42.service.IWinningStrategy;
import org.cp.LLD.connect42.service.PieceFactory;
import org.cp.LLD.connect42.service.impl.BestMoveStrategy;
import org.cp.LLD.connect42.service.impl.HorizontalWinningStrategy;
import org.cp.LLD.connect42.service.impl.VerticalWinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        LinkedList<Player> players = new LinkedList<>(Arrays.asList(
                new Player("Amarjeet", PieceFactory.getPiece("X"), false),
                new Player("Computer", PieceFactory.getPiece("O"), true)
        ));

        List<IWinningStrategy> winningStrategies = new ArrayList<>(
                Arrays.asList(new HorizontalWinningStrategy(), new VerticalWinningStrategy())
        );


        Game game = new Game(5, 5, players, winningStrategies, new BestMoveStrategy(winningStrategies));
        game.beginGame();
    }
}
