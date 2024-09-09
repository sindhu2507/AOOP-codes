package notificationSystem;

class PushNotification extends Notification {
    @Override
    protected void prepareNotification() {
        System.out.println("Preparing push notification...");
    }

    @Override
    protected void sendNotification(String message) {
        System.out.println("Sending push notification: " + message);
    }
}
