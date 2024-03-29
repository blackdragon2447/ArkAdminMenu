package com.blackdragon2447.AAM.util.obj.auth;

import java.util.HashMap;

import com.blackdragon2447.AAM.util.Utils;

public class Server extends IndexedServer implements AuthClass{

	private String[] OwnedIPs;
	private Integer[] DisabledCommands;
	
	public Server(String Name, Integer ServerID, Long[] Admins) {
		super(Name, ServerID, Admins);
	}
	
	public Server(String Name, Long[] Admins) {
		super(Name, Admins);
	}

	public Server(String Name, Integer ServerID, Long[] Admins, String[] OwnedIPs) {
		super(Name, ServerID, Admins);
		this.OwnedIPs = OwnedIPs;
	}
	
	public Server(String Name, Long[] Admins, String[] OwnedIPs) {
		super(Name, Admins);
		this.OwnedIPs = OwnedIPs;
	}
	
	public Server(String Name, Integer ServerID, Long[] Admins, String[] OwnedIPs, Integer[] DiabledCommands) {
		super(Name, ServerID, Admins);
		this.OwnedIPs = OwnedIPs;
		this.DisabledCommands = DiabledCommands;
	}
	
	public Server(String Name, Long[] Admins, String[] OwnedIPs, Integer[] DiabledCommands) {
		super(Name, Admins);
		this.OwnedIPs = OwnedIPs;
		this.DisabledCommands = DiabledCommands;
	}
	
	public String[] getOwnedIPs() {
		return OwnedIPs;
	}
	
	public Integer[] getDisabledCommands() {
		return DisabledCommands;
	}
	
	public void addOwnedIP(String IP){
		OwnedIPs = Utils.AddToArray(OwnedIPs, IP);
	}
	
	public void addDisavledCommand(int Command){
		DisabledCommands = Utils.AddToArray(DisabledCommands, Command);
	}
	
	
	public HashMap<String, Object> ToHashMap() {
		HashMap<String, Object> Data = new HashMap<>();
		Data.put("Name", this.Name);
		Data.put("ServerID", this.ServerID);
		Data.put("Asmins", this.Admins);
		Data.put("OwnedIPs", this.OwnedIPs);
		Data.put("DisabledCommands", this.DisabledCommands);
		
		return Data;
	}

}
