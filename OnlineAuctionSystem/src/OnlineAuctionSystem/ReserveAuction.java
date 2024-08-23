package OnlineAuctionSystem;

public class ReserveAuction extends Auction{
	@Override
    protected void auctionProcess() {
        notifyObservers("Reserve auction is in progress.");
        
        System.out.println("ReserveAuction: Bidding is open with a reserve price.");
    }
}
