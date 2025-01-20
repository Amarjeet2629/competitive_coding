package org.cp.LLD.connect4;

import org.cp.LLD.connect4.service.GameManager;
import org.cp.LLD.connect4.service.IObservable;
import org.cp.LLD.connect4.service.impl.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String ...args){
        IObservable gameEventNotifier = new GameEventNotifier();
        gameEventNotifier.add(new UiLogger());

        GameManager gameManager = new GameManager(4, 4, new ArrayList<>(
                Arrays.asList(
                        new HorizontalWinningStrategy(),
                        new VerticalWinningStrategy(),
                        new MajorDiagonalWinningStrategy(),
                        new MinorDiagonalWinningStrategy())
        ), gameEventNotifier);

        gameManager.beginGame();

    }
}
