package notificationSystem;

public abstract class Notification {
	public final void send(String message) {
        prepareNotification();
        sendNotification(message);
        logNotification();
    }

    protected abstract void prepareNotification();
    protected abstract void sendNotification(String message);

    private void logNotification() {
        System.out.println("Notification has been logged.");
    }
}
