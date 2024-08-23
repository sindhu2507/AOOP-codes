package OnlineAuctionSystem;

public class StandardAuction extends Auction{
	@Override
    protected void auctionProcess() {
        notifyObservers("Standard auction is in progress.");
       
        System.out.println("StandardAuction: Bidding is open.");
    }
}
