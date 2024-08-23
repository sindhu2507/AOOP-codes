package OnlineAuctionSystem;

public class Client {

	public static void main(String[] args) {
		
		Bidder bidder1 = new Bidder("Bidder 1");
        Bidder bidder2 = new Bidder("Bidder 2");

       
        Auction standardAuction = new StandardAuction();
        standardAuction.addObserver(bidder1);
        standardAuction.addObserver(bidder2);

        
        standardAuction.startAuction();

        
        Auction reserveAuction = new ReserveAuction();
        reserveAuction.addObserver(bidder1);

        
        reserveAuction.startAuction();

	}

}
