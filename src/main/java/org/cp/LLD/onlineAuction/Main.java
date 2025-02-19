package org.cp.LLD.onlineAuction;

import org.cp.LLD.onlineAuction.service.AuctionService;
import org.cp.LLD.onlineAuction.service.OnlineAuction;
import org.cp.LLD.onlineAuction.service.UserService;

public class Main {
    public static void main(String ...args){
        OnlineAuction onlineAuction = new OnlineAuction(new UserService(), new AuctionService());
        /*
        * ADD_BUYER("buyer1")
        • ADD_BUYER("buyer2")
        • ADD_BUYER("buyer3")
        • ADD_SELLER("seller1")
        • CREATE_AUCTION ("A1", "10", "50", "1", "seller1")
        • CREATE_BID("buyer1", "A1", "17")
        • CREATE_BID("buyer2", "A1", "15")
        • UPDATE_BID("buyer2", "A1", "19")
        • CREATE_BID("buyer3", "A1", "19")
        • CLOSE_AUCTION("A1") // Should give Buyer1 as winner
        • GET_PROFIT("seller1", "A1") // (17 + (3 * 0.2 * 1) - 30) = -12.4
        * */
        onlineAuction.addBuyer("buyer1");
        onlineAuction.addBuyer("buyer2");
        onlineAuction.addBuyer("buyer3");

        onlineAuction.addSeller("seller1");

        onlineAuction.createAuction("A1", 10, 50, 1, "seller1");

        onlineAuction.createBid("buyer1", "A1", 17);
        onlineAuction.createBid("buyer2", "A1", 15);
        onlineAuction.updateBid("buyer2", "A1", 19);
        onlineAuction.createBid("buyer3", "A1", 19);

        onlineAuction.closeAuction("A1");
        System.out.println(onlineAuction.getProfitOrLoss("seller1", "A1"));

        /*
         ADD_SELLER("seller2")
        • CREATE_AUCTION("A2", "5", "20", "2", "seller2")
        • CREATE_BID("buyer3", "A2", 25) //This should fail as highest bid limit is 20 for A2
        • CREATE_BID("buyer2, "A2", 5)
        • WITHDRAW_BID("buyer2", "A2")
        • CLOSE_AUCTION("A2") // No winner
        • GET_PROFIT("seller2", "A2") // (1 * 0.2 * 2) = 0.4 only consider profit from participation cost
         */

        onlineAuction.addSeller("seller2");
        onlineAuction.createAuction("A2", 5, 20, 2, "seller2");
        onlineAuction.createBid("buyer3", "A2", 25);
        onlineAuction.createBid("buyer2", "A2", 5);
        onlineAuction.withdraw("buyer2", "A2");
        onlineAuction.closeAuction("A2");
        onlineAuction.closeAuction("A2");

        System.out.println(onlineAuction.getProfitOrLoss("seller2", "A2"));

    }


}
