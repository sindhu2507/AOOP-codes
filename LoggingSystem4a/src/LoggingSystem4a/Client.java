package LoggingSystem4a;

public class Client {

	public static void main(String[] args) {
		
		LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();

        
        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);

        
        Command infoCommand = new LogCommand(infoHandler);
        Command debugCommand = new LogCommand(debugHandler);
        Command errorCommand = new LogCommand(errorHandler);

        
        Logger logger = new Logger();
        logger.addCommand(infoCommand);
        logger.addCommand(debugCommand);
        logger.addCommand(errorCommand);

        
        logger.processCommands();

       
        infoHandler.handle("INFO: Application started.");
        debugHandler.handle("DEBUG: Loading configuration.");
        errorHandler.handle("ERROR: Failed to load configuration.");
	}

}
