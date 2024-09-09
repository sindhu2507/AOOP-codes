package notificationSystem;

class NotificationObserver implements Observer {
    private Notifier notifier;

    public NotificationObserver(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void update(String eventType, String message) {
        notifier.notifyUser(message);
    }
}