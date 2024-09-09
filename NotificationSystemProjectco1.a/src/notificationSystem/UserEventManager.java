package notificationSystem;
import java.util.ArrayList;
import java.util.List;

public class UserEventManager {
	 private List<Observer> observers = new ArrayList<>();

	    public void subscribe(Observer observer) {
	        observers.add(observer);
	    }

	    public void notifyObservers(String eventType, String message) {
	        for (Observer observer : observers) {
	            observer.update(eventType, message);
	        }
	    }

	    public void userRegistered() {
	        notifyObservers("USER_REGISTERED", "Welcome! Your registration is successful.");
	    }

	    public void passwordReset() {
	        notifyObservers("PASSWORD_RESET", "Your password has been reset successfully.");
	    }
}
