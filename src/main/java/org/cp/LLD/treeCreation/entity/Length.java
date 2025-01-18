package org.cp.LLD.treeCreation.entity;

import java.util.Random;

public enum Length {
    SMALL(false),
    MEDIUM(false),
    TALL(true);

    private static final Random random = new Random();
    private final boolean rare;

    Length(boolean rare){
        this.rare = rare;
    }

    public static Length getRandom(){
        int len = Length.values().length;
        Length[] availableLengths = Length.values();
        int index = random.nextInt(0, len);

        Length length =  availableLengths[index];

        if(length.rare){
            double confidenceInterval = Math.random() * 10;
            if(confidenceInterval <= 0.001){
                return length;
            }

            Length tmp = availableLengths[len - 1];
            availableLengths[len - 1] = availableLengths[index];
            availableLengths[index] = tmp;

            index = random.nextInt(0, len - 1);
            return availableLengths[index];

        } else {
            return length;
        }

    }
}
