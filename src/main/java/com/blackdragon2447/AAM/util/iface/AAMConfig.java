package com.blackdragon2447.AAM.util.iface;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;

/**
 * the config interface for the program
 * @author Blackdragon2447
 */
@Sources({"file:AAMConfig.properties"})
public interface AAMConfig extends Accessible, Mutable{
	
	String CustomPrefix();
	
	int[] Favorites();
	
	String[] ScriptCommands();
	
	String[] ScriptCommandsNames();
	
	String[] PluginCommands();
	
	String[] PluginCommandsNames();
	
	String[] PluginCommandsArgs();
	
	String[] CommandSeriesName();
	
	@DefaultValue("true")
	Boolean ShowWelcome();
	
	String[] ServerNames();
	
	String[] IPs();
	
	int[] Ports();
	
	int LastLogin();
	
	@DefaultValue("0")
	int Theme();
	
	@DefaultValue("server")
	String UserName();
	
}
