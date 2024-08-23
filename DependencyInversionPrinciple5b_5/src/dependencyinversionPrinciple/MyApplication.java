package dependencyinversionPrinciple;

public class MyApplication {
	private MessageService messageService;

    public MyApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message, String receiver) {
        messageService.sendMessage(message, receiver);
    }
}
