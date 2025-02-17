package org.cp.LLD.NFT.entity;

import java.util.Random;

public enum Eyes {
    BLUE(0.99999999),
    GREEN(0),
    YELLOW(0);

    private double rarityIndex;

    Eyes(double rarityIndex){
        this.rarityIndex = rarityIndex;
    }

    public static Eyes getRandom(){
        Random random = new Random();
        while(true){
            int len = random.nextInt(0,  Eyes.values().length);
            double rarity = Eyes.values()[len].rarityIndex;

            //generate a confidence
            if(Math.random() >= rarity){
                return Eyes.values()[len];
            }
        }
    }
}
