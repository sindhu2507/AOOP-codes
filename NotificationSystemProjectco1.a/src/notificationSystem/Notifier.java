package notificationSystem;

public class Notifier {
	private Notification notificationService;

    public Notifier(Notification notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message) {
        notificationService.send(message);
    }
}
