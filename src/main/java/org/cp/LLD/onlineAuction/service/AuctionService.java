package org.cp.LLD.onlineAuction.service;

import org.cp.LLD.onlineAuction.entity.Auction;
import org.cp.LLD.onlineAuction.entity.Bid;
import org.cp.LLD.onlineAuction.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AuctionService {
    List<Auction> auctionList;

    public AuctionService(){
        this.auctionList = new ArrayList<>();
    }

    private Auction getAuctionById(String auctionId){
        for(Auction auction: auctionList){
            if(auction.getId().equals(auctionId)) return auction;
        }

        throw new RuntimeException("Auction doesn't exists");
    }

    public Auction createAuction(String auctionId, double minBid, double maxBid, double participationCost, User seller){
        this.auctionList.add(new Auction(auctionId, auctionId, minBid, maxBid, seller, participationCost));

        return this.auctionList.get(auctionList.size() - 1);
    }

    private void isBidValid(double bidPrice, Auction auction){
        if(bidPrice < auction.getMinBid() || bidPrice > auction.getMaxBid()){
            throw new RuntimeException("Bid price not in bounds !!!");
        }
    }

    private void isAuctionActive(Auction auction){
        if(!auction.getActive()) throw new RuntimeException("Auction not active");
    }

    public void createNewBid(User buyer, String auctionId, double bidPrice){
        Auction auction = getAuctionById(auctionId);
        isBidValid(bidPrice, auction);
        isAuctionActive(auction);

        List<Bid> bids = auction.getBids();
        Bid bid = new Bid("Bid-Id-" + (bids.size() + 1), auctionId, buyer, bidPrice);

        bids.add(bid);
        auction.setBids(bids);
        auction.incrementParticipant();
    }

    public Bid getBidFromAuction(String auctionId, User buyer){
        Auction auction = getAuctionById(auctionId);

        for(Bid bid: auction.getBids()){
            if(bid.getUser().getName().equals(buyer.getName())){
                return bid;
            }
        }

        return null;
    }

    public void updateBid(User buyer, String auctionId, double bidPrice){
        Auction auction = getAuctionById(auctionId);
        isBidValid(bidPrice, auction);
        isAuctionActive(auction);

        List<Bid> bids = auction.getBids();
        boolean[] isBidPresent = new boolean[1];
        isBidPresent[0] = false;

        bids = bids.stream().map(bid -> {
            if(bid.getUser().getName() != buyer.getName()) return bid;
            isBidPresent[0] = true;

            Bid newBid = new Bid(bid.getId(), auctionId, buyer, bidPrice);
            return newBid;

        }).collect(Collectors.toCollection(ArrayList::new));

        if(!isBidPresent[0]){
            throw new RuntimeException("Bid is not present, can't update.");
        }

        auction.setBids(bids);
    }

    public void closeAuction(String auctionId){
        Auction auction = getAuctionById(auctionId);
        if(!auction.getActive()){
            throw new RuntimeException("Auction is already closed.");
        }
        auction.setIsActive(false);
    }

    public double getProfitOrLoss(String auctionId){
        Auction auction = getAuctionById(auctionId);
        List<Bid> bidList = auction.getBids();
        if(auction.getActive()){
            throw new RuntimeException("Auction is still open");
        }

        double maxBidPrice = -1;
        HashMap<Double, Integer> priceVsNumberOfBids = new HashMap<>();

        for(Bid bid: bidList){
            priceVsNumberOfBids.put(bid.getBidPrice(), priceVsNumberOfBids.getOrDefault(bid.getBidPrice(), 0) + 1);
        }

        for(Double bidPrice: priceVsNumberOfBids.keySet()){
            if(priceVsNumberOfBids.get(bidPrice).equals(1)){
                maxBidPrice = Math.max(maxBidPrice, bidPrice);
            }
        }

        if(maxBidPrice == -1){
            return auction.getParticipantCount() * 0.2 * auction.getParticipationCost();
        } else {
           return maxBidPrice +  auction.getParticipantCount() * 0.2 * auction.getParticipationCost() - (auction.getMaxBid() + auction.getMinBid()) * 0.5;
        }
    }

    public void withdrawBid(String  buyerId, String auctionId){
        Auction auction = getAuctionById(auctionId);
        List<Bid> bids = auction.getBids();

        bids = bids.stream().filter(bid -> !bid.getUser().getName().equals(buyerId)).collect(Collectors.toCollection(ArrayList::new));
        auction.setBids(bids);
    }
}
