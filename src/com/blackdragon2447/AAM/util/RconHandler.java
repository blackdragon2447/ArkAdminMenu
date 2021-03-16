package com.blackdragon2447.AAM.util;

import java.io.IOException;

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
		System.out.println("sending command");
		String Result = rcon.command(command);
		System.out.println("command sent");
		//rcon.disconnect();
		return Result;
	}
	
	public static String MultipleCommand(String command) throws IOException, AuthenticationException {
		Rcon rcon = null;
		String FullResult = "";
		String Result;
		
		for (Server server : Reference.LoggedServers) {
			rcon = new Rcon(server.getIP(), server.getPort(), server.getPassword().getBytes());
			Result = rcon.command(command);
			
			FullResult = FullResult + server.getName() + "\n" + Result;
		}
		//rcon.disconnect();
		return FullResult;
	}

}
