package org.cp.LLD.onlineAuction.entity;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    String id;
    String name;
    List<Bid> bids;
    double minBid;
    double maxBid;
    User seller;
    Boolean isActive;
    double participationCost;
    int participantCount;

    public Auction(String id, String name, double minBid, double maxBid, User seller, double participationCost) {
        this.id = id;
        this.name = name;
        this.minBid = minBid;
        this.maxBid = maxBid;
        this.seller = seller;
        this.participationCost = participationCost;
        this.bids = new ArrayList<>();
        this.isActive = true;
        this.participantCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public double getMinBid() {
        return minBid;
    }

    public double getMaxBid() {
        return maxBid;
    }

    public User getSeller() {
        return seller;
    }

    public Boolean getActive() {
        return isActive;
    }

    public double getParticipationCost() {
        return participationCost;
    }

    public void setBids(List<Bid> bids){
        this.bids = bids;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }

    public void incrementParticipant(){
        this.participantCount += 1;
    }

    public int getParticipantCount(){
        return this.participantCount;
    }
}
