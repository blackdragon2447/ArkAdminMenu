package com.blackdragon2447.AAM.util;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Mutable;


@Sources({"file:AAMConfig.properties"})
public interface AAMConfig extends Accessible, Mutable{
	
	@DefaultValue("false")
	Boolean Darkmode();
	
	String CustomPrefix();
	
	int[] Favorites();
	
	@DefaultValue("true")
	Boolean ShowWelcome();
	
}
