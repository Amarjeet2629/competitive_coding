package org.cp.LLD.NFT.service;

import org.cp.LLD.NFT.entity.Eyes;
import org.cp.LLD.NFT.entity.Hair;
import org.cp.LLD.NFT.entity.Height;
import org.cp.LLD.NFT.entity.Nft;

public class NftBuilder {
    Hair hair;
    Eyes eyes;
    Height height;

    public NftBuilder(){};

    public NftBuilder setHair(Hair hair){
        this.hair = hair;
        return this;
    }

    public NftBuilder setEyes(Eyes eyes){
        this.eyes = eyes;
        return this;
    }

    public NftBuilder setHeight(Height height){
        this.height = height;
        return this;
    }

    public Nft build(){
        return new Nft(this);
    }

    public Hair getHair() {
        return hair;
    }

    public Height getHeight(){
        return height;
    }

    public Eyes getEyes(){
        return eyes;
    }
}
