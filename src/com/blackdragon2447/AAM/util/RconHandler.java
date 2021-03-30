package com.blackdragon2447.AAM.util;

import java.io.IOException;
import java.util.logging.Level;

import com.blackdragon2447.AAM.Main;
import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.util.obj.Server;

import net.kronos.rkon.core.Rcon;
import net.kronos.rkon.core.ex.AuthenticationException;

/**
 * handles rcon commands
 * @author Blackdragon2447
 */
public class RconHandler {

	/**
	 * sends an rcon command
	 * @param command the command to be sent
	 * @return the servers response or if the server recived the message in case of no response
	 * @throws IOException thrown if the server cant be reached.
	 * @throws AuthenticationException thrown if the password is incorrect.
	 */
	public static String command(String command) throws IOException, AuthenticationException {
		final Rcon rcon = new Rcon(Reference.RConIp, Reference.RConPort, Reference.Password.getBytes());
		Main.logger.LogUser("to: " + Reference.ServerName +" sending command: " + command, Level.INFO);
		String Result = rcon.command(command);
		return Result;
	}
	
	public static String command(String command, String name) throws IOException, AuthenticationException {
		final Rcon rcon = new Rcon(Reference.RConIp, Reference.RConPort, Reference.Password.getBytes());
		Main.logger.LogUser("to: " + name +" sending command: " + command, Level.INFO);
		String Result = rcon.command(command);
		return Result;
	}
	
	public static String MultipleCommand(String command) throws IOException, AuthenticationException {
		Rcon rcon = null;
		String FullResult = "";
		String Result;
		
		for (Server server : Reference.LoggedServers) {
			rcon = new Rcon(server.getIP(), server.getPort(), server.getPassword().getBytes());
			Main.logger.LogUser("to: " + server.getName() +" sending command: " + command, Level.INFO);
			Result = rcon.command(command);
			
			FullResult = FullResult + server.getName() + "\n" + Result;
		}
		return FullResult;
	}
	
	public static String RefreshCommand(String command) throws IOException, AuthenticationException {
		final Rcon rcon = new Rcon(Reference.RConIp, Reference.RConPort, Reference.Password.getBytes());
		String Result = rcon.command(command);
		return Result;
	}
	
	public static String RefreshMultipleCommand(String command) throws IOException, AuthenticationException {
		Rcon rcon = null;
		String FullResult = "";
		String Result;
		
		for (Server server : Reference.LoggedServers) {
			rcon = new Rcon(server.getIP(), server.getPort(), server.getPassword().getBytes());
			Result = rcon.command(command);
			
			FullResult = FullResult + server.getName() + "\n" + Result;
		}
		return FullResult;
	}

}
