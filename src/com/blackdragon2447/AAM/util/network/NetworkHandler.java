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
			System.out.println("connecting");
			socket = new Socket("localhost", 6666);
			System.out.println("connected");
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
		return null;
		
		//return dataIn.readUTF();
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
