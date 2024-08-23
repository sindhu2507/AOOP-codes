package LoggingSystem4a;

abstract class LogHandler {
	protected LogHandler nextHandler;

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(String message);
}
