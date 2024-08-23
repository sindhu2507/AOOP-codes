package dependencyinversionPrinciple;

public class Main {
	public static void main(String[] args) {
        MessageService emailService = new EmailService();
        MyApplication app = new MyApplication(emailService);
        app.processMessage("Hello, John!", "john@example.com");

        MessageService smsService = new SMSService();
        app = new MyApplication(smsService);
        app.processMessage("Hello, Jane!", "123-456-7890");
    }

}
