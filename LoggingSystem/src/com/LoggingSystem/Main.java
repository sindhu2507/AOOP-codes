package com.LoggingSystem;

public class Main {

	public static void main(String[] args) {
		
		Logger logger = Logger.getInstance();

        logger.log("Application started.");
        logger.log("Performing some tasks...");
        logger.log("Application ended.");

        Logger anotherLogger = Logger.getInstance();

        anotherLogger.log("This is still the same logger instance.");

        System.out.println("Are both loggers the same instance? " + (logger == anotherLogger));

	}
	
}
