package org.cp.LLD.NFT.entity;

import java.util.Random;

public enum Height {
    TALL,
    SHORT;

    public static Height getRandom(){
        Random random = new Random();
        return Height.values()[random.nextInt(0, Height.values().length)];
    }
}
