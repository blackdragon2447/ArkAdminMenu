package com.blackdragon2447.AAM.util;

import java.io.IOException;

import com.blackdragon2447.AAM.Reference;

import net.kronos.rkon.core.Rcon;
import net.kronos.rkon.core.ex.AuthenticationException;

public class RconHandler {

	public static String command(String command) throws IOException, AuthenticationException {
		final Rcon rcon = new Rcon(Reference.RConIp, Reference.RConPort, Reference.Password.getBytes());
		
		return rcon.command(command);
	}

}
