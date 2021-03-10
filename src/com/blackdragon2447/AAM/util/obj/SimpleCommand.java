package com.blackdragon2447.AAM.util.obj;

import com.blackdragon2447.AAM.Reference;

/**
 * the object class for the simple command datatype
 * @author Blackdragon2447
 *
 */
public class SimpleCommand {
	
	private String Prefix;
	private String Command;
	private int Index;
	private boolean HasArguments;
	private String Arguments;
	private String[] ArgumentsList = {""};
	
	/**
	 * the constructor
	 * @param index the index in the {@link Reference#SimpleCommandList} of the command
	 * @param Arguments the argument of the command
	 */
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
	
	@Deprecated
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
	
	@Deprecated
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
	
	/**
	 * @return outputs the string version of the command
	 */
	public String generateCommand() {
		
		if(HasArguments) return Command + Arguments;
		else return Command;
		
	}
	
	/**
	 * @return returns a {@link GenericCommand} obj for the simple command
	 */
	public GenericCommand generateGenericCommand() {
		return new GenericCommand(Index, ArgumentsList);
		
	}

}
