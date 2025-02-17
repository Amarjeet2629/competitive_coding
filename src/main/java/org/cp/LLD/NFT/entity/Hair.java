package org.cp.LLD.NFT.entity;

import java.util.Random;

public enum Hair {
    BLACK,
    BROWN,
    BLUE;

    Hair(){};

    public static Hair getRandom(){
        Random random = new Random();
        return Hair.values()[random.nextInt(0, Hair.values().length)];
    }
}
