package com.blackdragon2447.AAM.util.logger;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AAMLogger {
	
	private final Logger USER_LOGGER = Logger.getLogger("Commands");
	private final Logger DEBUG_LOGGER = Logger.getLogger("Debug");
	
	public AAMLogger(Level CommandLevel, Level DebugLevel, Boolean DebugEnabled) {
		USER_LOGGER.setLevel(CommandLevel);
		if(DebugEnabled == true) DEBUG_LOGGER.setLevel(DebugLevel);
		else DEBUG_LOGGER.setLevel(Level.OFF);
	}
	
	public void LogDebug(String log) {
		DEBUG_LOGGER.info(log);
	}
	
	public void LogUser(String log) {
		USER_LOGGER.info(log);
	}
	
	public void AddFileHandlerDebug(FileHandler handler) {
		handler.setFormatter(new SimpleFormatter());
		DEBUG_LOGGER.addHandler(handler);
		DEBUG_LOGGER.info("Added File");
	}
	
	public void AddFileHandlerUser(FileHandler handler) {
		handler.setFormatter(new SimpleFormatter());
		USER_LOGGER.addHandler(handler);
		USER_LOGGER.info("Added File");
	}

}
