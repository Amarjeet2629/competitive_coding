package org.cp.LLD.onlineAuction.service;

import org.cp.LLD.onlineAuction.entity.Auction;
import org.cp.LLD.onlineAuction.entity.Bid;
import org.cp.LLD.onlineAuction.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnlineAuction {
    UserService userService;
    AuctionService auctionService;

    public OnlineAuction(UserService userService, AuctionService auctionService){
        this.userService = userService;
        this.auctionService = auctionService;
    }

    public void addBuyer(String name){
        try {
            userService.createBuyer(name);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void addSeller(String name){
        try {
            userService.createSeller(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createAuction(String auctionId, double minBidPrice, double maxBidPrice, double participationCost, String sellerId){
        try {
            User seller = userService.getUserById(sellerId);
            Auction auction = auctionService.createAuction(auctionId, minBidPrice, maxBidPrice, participationCost, seller);

            List<Auction> auctionsByUser = seller.getAuctionsByUser();
            auctionsByUser.add(auction);

            seller.setAuctionsByUser(auctionsByUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void createBid(String buyerId, String auctionId, double bidPrice){
        try {
            User buyer = userService.getUserById(buyerId);
            auctionService.createNewBid(buyer, auctionId, bidPrice);

            Bid bid = auctionService.getBidFromAuction(auctionId, buyer);
            List<Bid> bidList = buyer.getBidsByUser();
            bidList.add(bid);

            buyer.setBidsByUser(bidList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBid(String buyerId, String auctionId, double bidPrice){
        try {
            User buyer = userService.getUserById(buyerId);
            auctionService.updateBid(buyer, auctionId, bidPrice);

            List<Bid> bidList = buyer.getBidsByUser();
            bidList = bidList.stream().map(bid -> {
                if(bid.getAuctionId() != auctionId) return bid;

                return new Bid(bid.getId(), auctionId, buyer, bidPrice);
            }).collect(Collectors.toCollection(ArrayList::new));

            buyer.setBidsByUser(bidList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeAuction(String auctionId){
        try{
            auctionService.closeAuction(auctionId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public double getProfitOrLoss(String sellerId, String auctionId){
        try {
            return auctionService.getProfitOrLoss(auctionId);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        return 0;
    }

    public void withdraw(String buyerId, String auctionId){
        try {
            auctionService.withdrawBid(buyerId, auctionId);
            userService.withdrawBid(buyerId, auctionId);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

}
