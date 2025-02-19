package org.cp.LLD.onlineAuction.service;

import org.cp.LLD.onlineAuction.entity.Bid;
import org.cp.LLD.onlineAuction.entity.User;
import org.cp.LLD.onlineAuction.entity.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    List<User> userList;

    public UserService(){
        this.userList = new ArrayList<>();
    }

    public User getUserById(String userId){
        for(User user: userList){
            if(Objects.equals(user.getName(), userId)) return user;
        }

        return null;
    }

    public void createBuyer(String name){
        if(getUserById(name) != null) throw new RuntimeException("Duplicate user found!!!");
        this.userList.add(new User(name, UserType.BUYER));
    }

    public void createSeller(String name){
        if(getUserById(name) != null) throw new RuntimeException("Duplicate user found!!!");
        this.userList.add(new User(name, UserType.SELLER));
    }

    public void updateBid(String buyerId, String auctionId, double bidPrice){
        User user = getUserById(buyerId);
        if(user == null){
            throw new RuntimeException("User doesn't exits.");
        }

        final boolean[] isBidPresent = new boolean[1];
        isBidPresent[0] = false;

        List<Bid> bidList = user.getBidsByUser();

        bidList = bidList.stream().map(bid -> {
           if(bid.getAuctionId() != auctionId) return bid;

           isBidPresent[0] = true;
           Bid newBid = new Bid(bid.getId(), bid.getAuctionId(), user, bidPrice);

           return newBid;
        }).collect(Collectors.toCollection(ArrayList::new));;

        if(!isBidPresent[0]){
            throw new RuntimeException("Bid is not present for this user.");
        }

        user.setBidsByUser(bidList);
    }

    public void withdrawBid(String buyerId, String auctionId){
        User buyer = getUserById(buyerId);
        List<Bid> bids = buyer.getBidsByUser().stream().filter(bid -> bid.getAuctionId() != auctionId).collect(Collectors.toCollection(ArrayList::new));
        buyer.setBidsByUser(bids);
    }
}
