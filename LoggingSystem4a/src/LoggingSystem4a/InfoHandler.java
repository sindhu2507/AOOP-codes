package LoggingSystem4a;

public class InfoHandler extends LogHandler{
	@Override
    public void handle(String message) {
        if (message.startsWith("INFO:")) {
            System.out.println("InfoHandler: " + message);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
