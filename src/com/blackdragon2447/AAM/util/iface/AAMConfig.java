package com.blackdragon2447.AAM.util.iface;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;


@Sources({"file:AAMConfig.properties"})
public interface AAMConfig extends Accessible, Mutable{
	
	@DefaultValue("false")
	Boolean Darkmode();
	
	String CustomPrefix();
	
	int[] Favorites();
	
	String[] ScriptCommands();
	
	String[] ScriptCommandsNames();
	
	String[] PluginCommands();
	
	String[] PluginCommandsNames();
	
	String[] PluginCommandsArgs();
	
	String[] CommandSeriesName();
	
	String[][] CommandSeries();
	
	@DefaultValue("true")
	Boolean ShowWelcome();
	
	String[] ServerNames();
	
	String[] IPs();
	
	int[] Ports();
	
}
