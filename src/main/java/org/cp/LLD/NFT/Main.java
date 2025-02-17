package org.cp.LLD.NFT;

import org.cp.LLD.NFT.entity.Eyes;
import org.cp.LLD.NFT.entity.Hair;
import org.cp.LLD.NFT.entity.Height;
import org.cp.LLD.NFT.entity.Nft;
import org.cp.LLD.NFT.service.NftBuilder;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<Nft> nftSet = new HashSet<>();

        for(int i = 0; i < 100000000; i++){
            NftBuilder nftBuilder = new NftBuilder();
            nftSet.add(
                            nftBuilder
                            .setEyes(Eyes.getRandom())
                            .setHair(Hair.getRandom())
                            .setHeight(Height.getRandom())
                            .build());
        }

        for(Nft nft: nftSet){
            System.out.println(nft);
        }
    }
}
