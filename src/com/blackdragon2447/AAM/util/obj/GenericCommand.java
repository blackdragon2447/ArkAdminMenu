package com.blackdragon2447.AAM.util.obj;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;

public class GenericCommand {
	
	private String Prefix;
	private String Command;
	private String[] Arguments;
	
	public GenericCommand(String prefix, int index, String[] Arguments) {
		
		if (AAMGui.PFcheatRadioItem.isSelected() == true) {
			this.Prefix = "cheat ";
		}else if (AAMGui.PFacheatRadioItem.isSelected() == true) {
			this.Prefix = "admincheat ";
		}else {
			this.Prefix = Reference.CustomPrefix + " ";
		}
		
		if(this.Prefix == " ") this.Prefix = "";
		
		this.Command = Reference.SimpleCommandList.get(index).getFirstValue();
		
		this.Command = Command + " ";
		this.Arguments = Arguments;
	}
	
	public String getPrefix() {
		return Prefix;
	}
	
	public String getCommand() {
		return Command;
	}
	
	public String[] getArguments() {
		return Arguments;
	}
	
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	
	public void setCommand(String command) {
		Command = command;
	}
	
	public void setArguments(String arguments[]) {
		Arguments = arguments;
	}
	
	public String generateCommand() {
		
		String result;
		
		result = Prefix + Command;
		
		if(Arguments.length != 0) {
			for(int i = 0; i < Arguments.length; i++) {
				result = result + Arguments[i];
			}
			
		}
		
		return result;
		
	}

}
