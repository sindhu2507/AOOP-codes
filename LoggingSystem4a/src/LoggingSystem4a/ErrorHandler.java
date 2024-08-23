package LoggingSystem4a;

public class ErrorHandler extends LogHandler{
	@Override
    public void handle(String message) {
        if (message.startsWith("ERROR:")) {
            System.out.println("ErrorHandler: " + message);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
