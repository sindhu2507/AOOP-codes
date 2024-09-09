package notificationSystem;

public class NotificationSystemDemo {
	public static void main(String[] args) {
        // Create notification services
        Notifier emailNotifier = new Notifier(new EmailNotification());
        Notifier smsNotifier = new Notifier(new SMSNotification());
        Notifier pushNotifier = new Notifier(new PushNotification());

        // Create event manager
        UserEventManager eventManager = new UserEventManager();

        // Subscribe observers
        eventManager.subscribe(new NotificationObserver(emailNotifier));
        eventManager.subscribe(new NotificationObserver(smsNotifier));
        eventManager.subscribe(new NotificationObserver(pushNotifier));

        // Trigger events
        eventManager.userRegistered();
        eventManager.passwordReset();
    }
}
