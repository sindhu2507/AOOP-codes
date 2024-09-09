package notificationSystem;

class EmailNotification extends Notification {
    @Override
    protected void prepareNotification() {
        System.out.println("Preparing email notification...");
    }

    @Override
    protected void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}