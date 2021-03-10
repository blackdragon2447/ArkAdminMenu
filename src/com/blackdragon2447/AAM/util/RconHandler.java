package com.blackdragon2447.AAM.util;

import java.io.IOException;

import com.blackdragon2447.AAM.Reference;

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
		
		return rcon.command(command);
	}

}
