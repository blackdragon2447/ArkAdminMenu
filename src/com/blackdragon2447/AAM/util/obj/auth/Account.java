package com.blackdragon2447.AAM.util.obj.auth;

import java.util.HashMap;

public class Account implements AuthClass{

	private String UserName;
	private String Hash;
	private Long SteamID;
	private Integer[] DisabledCommands;
	private Boolean UserType; // true = Owner, false = Admin
	private Integer[] Servers; //allways a 9 diget number
	private Boolean Registered = false;
	
	/**
	 * Use this method when an Owner is creating accounds for admins
	 * @param SteamID
	 * @param IsOwner
	 */
	public Account(Long SteamID, Boolean IsOwner) {
		this.SteamID = SteamID;
		this.UserType = IsOwner;
	}
	
	/**
	 * Use this method to create a new owner account.
	 * @param UserName
	 * @param Hash
	 * @param SteamID
	 * @param IsOwner this one should be True
	 */
	public Account(String UserName, String Hash, Long SteamID, Boolean IsOwner) {
		this.SteamID = SteamID;
		this.UserType = IsOwner;
		register(UserName, Hash);
	}
	
	public void register(String UserName, String Hash) {
		this.Registered = true;
		this.UserName = UserName;
		this.Hash = Hash;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public String getHash() {
		return Hash;
	}
	
	public Long getSteamID() {
		return SteamID;
	}
	
	public Integer[] getDisabledCommands() {
		return DisabledCommands;
	}
	
	public Boolean isOwner() {
		return UserType;
	}
	
	public Integer[] getServers() {
		return Servers;
	}
	
	public Boolean isRegistered() {
		return Registered;
	}
	
	public void setDisabledCommands(Integer[] disabledCommands) {
		DisabledCommands = disabledCommands;
	}
	
	public HashMap<String, Object> ToHashMap() {
		HashMap<String, Object> Data = new HashMap<>();
		Data.put("UserName", this.UserName);
		Data.put("Hash", this.Hash);
		Data.put("SteamID", this.SteamID);
		Data.put("DisabledCommands", this.DisabledCommands);
		Data.put("UserType", this.UserType);
		Data.put("Servers", this.Servers);
		Data.put("Registered", this.Registered);
		
		return Data;
	}
}
