package com.blackdragon2447.AAM.util.obj;

import com.blackdragon2447.AAM.Reference;

public class GenericCommand {
	
	private String Command;
	private String[] Arguments;
	
	public GenericCommand(int index, String[] Arguments) {
		
		
		this.Command = Reference.SimpleCommandList.get(index).getFirstValue();
		
		this.Arguments = Arguments;
	}
	
	public GenericCommand(String command, String[] Arguments) {
		
		this.Command = command;
		
		this.Arguments = Arguments;
	}
	
	
	public String getCommand() {
		return Command;
	}
	
	public String[] getArguments() {
		return Arguments;
	}
	
	
	public void setCommand(String command) {
		Command = command;
	}
	
	public void setArguments(String arguments[]) {
		Arguments = arguments;
	}
	
	public String generateCommand() {
		
		String result;
		
		result = Command;
		
		if(Arguments != null) {
			if(Arguments.length != 0) {
				for(int i = 0; i < Arguments.length; i++) {
					result = result + " " + Arguments[i];
				}
				
			}
		}
		
		return result;
		
	}

}
