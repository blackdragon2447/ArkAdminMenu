package com.blackdragon2447.AAM.util.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkHandler {

	Socket socket;
	DataOutputStream dataOut;
	DataInputStream dataIn;
	
	public NetworkHandler() {
		try {
			socket = new Socket("192.168.178.69", 6666);
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataIn = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public String sendMessage(String msg) throws IOException {
		try {
			dataOut.writeUTF(msg);
			dataOut.flush();  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dataIn.readUTF();
	}
	
	public void close() {
		try {
			dataOut.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
