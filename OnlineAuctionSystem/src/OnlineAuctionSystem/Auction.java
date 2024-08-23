package OnlineAuctionSystem;
import java.util.ArrayList;
import java.util.List;
abstract public class Auction implements Subject{
	private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public final void startAuction() {
        notifyObservers("Auction is starting.");
        auctionProcess();
        notifyObservers("Auction has ended.");
    }

    protected abstract void auctionProcess();
}
