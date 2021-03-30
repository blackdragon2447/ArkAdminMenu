package com.blackdragon2447.AAM.util.logger;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AAMLogger {
	
	private final Logger USER_LOGGER = Logger.getLogger("Commands");
	private final Logger DEBUG_LOGGER = Logger.getLogger("Debug");
	
	public AAMLogger(Level CommandLevel, Level DebugLevel, Boolean DebugEnabled) {
		USER_LOGGER.setLevel(CommandLevel);
		USER_LOGGER.setUseParentHandlers(false);
		if(DebugEnabled == true) DEBUG_LOGGER.setLevel(DebugLevel);
		else DEBUG_LOGGER.setLevel(Level.OFF);
	}
	
	public void LogDebug(String log, Level level) {
		switch (level.intValue()) {
		case 300:
			DEBUG_LOGGER.finest(log);
			break;
		case 400:
			DEBUG_LOGGER.finer(log);
			break;
		case 500:
			DEBUG_LOGGER.fine(log);
			break;
		case 700:
			DEBUG_LOGGER.config(log);
			break;
		case 800:
			DEBUG_LOGGER.info(log);
			break;
		case 900:
			DEBUG_LOGGER.warning(log);
			break;
		case 1000:
			DEBUG_LOGGER.severe(log);
			break;
		default:
			break;
		}
		
	}
	
	public void LogUser(String log, Level level) {
		switch (level.intValue()) {
		case 300:
			USER_LOGGER.finest(log);
			break;
		case 400:
			USER_LOGGER.finer(log);
			break;
		case 500:
			USER_LOGGER.fine(log);
			break;
		case 700:
			USER_LOGGER.config(log);
			break;
		case 800:
			USER_LOGGER.info(log);
			break;
		case 900:
			USER_LOGGER.warning(log);
			break;
		case 1000:
			USER_LOGGER.severe(log);
			break;
		default:
			break;
		}
		
		LogDebug(log, level);
	}
	
	public void AddFileHandlerDebug(FileHandler handler) {
		handler.setFormatter(new SingleLineFormatter());
		DEBUG_LOGGER.addHandler(handler);
	}
	
	public void AddFileHandlerUser(FileHandler handler) {
		handler.setFormatter(new UserLogFormatter());
		USER_LOGGER.addHandler(handler);
	}
	

}
