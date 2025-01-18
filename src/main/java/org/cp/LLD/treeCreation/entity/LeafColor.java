package org.cp.LLD.treeCreation.entity;

import java.util.Random;

public enum LeafColor {
    GREEN,
    YELLOW,
    RED;

    private static final Random random = new Random();

    public static LeafColor getRandom(){
        int len = LeafColor.values().length;

        return LeafColor.values()[random.nextInt(0, len)];
    }
}
