package org.cp.LLD.NFT.entity;

import org.cp.LLD.NFT.service.NftBuilder;

import java.util.Objects;

public class Nft {
    Eyes eyes;
    Hair hair;
    Height height;

    public Nft(NftBuilder nftBuilder){
        this.height = nftBuilder.getHeight();
        this.hair = nftBuilder.getHair();
        this.eyes = nftBuilder.getEyes();
    }

    @Override
    public String toString() {
        return "[Eyes: " + this.eyes + ", Hair: " + this.hair + ", Height: " + this.height + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return false;
        Nft nft = (Nft) obj;

        return nft.eyes == this.eyes && nft.hair == this.hair && nft.height == this.height;
    }

    @Override
    public int hashCode(){
        return Objects.hash(eyes, hair, height);
    }
}
