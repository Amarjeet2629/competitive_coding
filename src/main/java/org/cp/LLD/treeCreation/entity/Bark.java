package org.cp.LLD.treeCreation.entity;

import java.util.Random;

public enum Bark {
    THICK,
    THIN;


    private static final Random random = new Random();

    Bark() {

    }

    public static Bark getRandom(){
        int len = Bark.values().length;
        return Bark.values()[random.nextInt(0, len)];
    }

}
