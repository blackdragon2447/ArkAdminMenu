package com.blackdragon2447.AAM.util.obj;

import com.blackdragon2447.AAM.Reference;

public class SimpleCommand {
	
	private String Prefix;
	private String Command;
	private int Index;
	private boolean HasArguments;
	private String Arguments;
	private String[] ArgumentsList = {""};
	
	public SimpleCommand(int index, String Arguments) {
				
		this.Command = Reference.SimpleCommandList.get(index).getFirstValue();
		
		if(Reference.SimpleCommandList.get(index).getSecondValue() == false) {
			HasArguments = false;
		}else {
			HasArguments = true;
			this.Command = Command + " ";
			this.Arguments = Arguments;
		}
		
		Index = index;
		
		ArgumentsList[0] = Arguments;
	}
	
	public String getPrefix() {
		return Prefix;
	}
	
	public String getCommand() {
		return Command;
	}
	
	public String getArguments() {
		return Arguments;
	}
	
	public Boolean getHasArguments() {
		return HasArguments;
	}
	
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	
	public void setCommand(String command) {
		Command = command;
	}
	
	public void setArguments(String arguments) {
		Arguments = arguments;
	}
	
	public void setHasArguments(boolean hasArguments) {
		this.HasArguments = hasArguments;
	}
	
	public String generateCommand() {
		
		if(HasArguments) return Prefix + Command + Arguments;
		else return Prefix + Command;
		
	}
	
	public GenericCommand generateGenericCommand() {
		return new GenericCommand(Index, ArgumentsList);
		
	}

}
