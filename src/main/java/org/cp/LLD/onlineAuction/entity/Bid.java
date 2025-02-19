package org.cp.LLD.onlineAuction.entity;

public class Bid {
    String id;
    String auctionId;
    double bidPrice;
    User user;

    public Bid(String id, String auctionId, User user, double bidPrice) {
        this.id = id;
        this.auctionId = auctionId;
        this.user = user;
        this.bidPrice = bidPrice;
    }

    public String getId() {
        return id;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public User getUser() {
        return user;
    }

    public void setBidPrice(double bidPrice){
        this.bidPrice = bidPrice;
    }
}
