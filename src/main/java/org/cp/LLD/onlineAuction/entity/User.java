package org.cp.LLD.onlineAuction.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    UserType userType;
    List<Bid> bidsByUser;
    List<Auction> auctionsByUser;

    public User(String name, UserType userType){
        this.userType = userType;
        this.name = name;
        this.bidsByUser = new ArrayList<>();
        this.auctionsByUser = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public List<Bid> getBidsByUser() {
        return bidsByUser;
    }

    public List<Auction> getAuctionsByUser() {
        return auctionsByUser;
    }

    public void setAuctionsByUser(List<Auction> auctionsByUser) {
        this.auctionsByUser = auctionsByUser;
    }

    public void setBidsByUser(List<Bid> bidsByUser) {
        this.bidsByUser = bidsByUser;
    }
}
