package com.blackdragon2447.AAM.util.obj;

public class Server {
	
	private String Name;
	private String IP;
	private int Port;
	private String Password;
	public Server(String name, String ip, int port, String password) {
		Name = name;
		IP = ip;
		Port = port;
		Password = password;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getIP() {
		return IP;
	}
	
	public int getPort() {
		return Port;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public void setIP(String ip) {
		IP = ip;
	}
	
	public void setPort(int port) {
		Port = port;
	}
	
	public void setPassword(String password) {
		Password = password;
	}

}
