package notificationSystem;

class SMSNotification extends Notification {
    @Override
    protected void prepareNotification() {
        System.out.println("Preparing SMS notification...");
    }

    @Override
    protected void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}