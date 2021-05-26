package com.blackdragon2447.AAM.util.network;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class NetworkHandler {

	Socket socket;
	DataOutputStream dataOut;
	BufferedWriter dataIn;

	public NetworkHandler() {
		try {
			System.out.println("connecting");
			socket = new Socket("localhost", 6666);
			System.out.println("connected");
			dataOut = new DataOutputStream(socket.getOutputStream());
			dataIn = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String sendMessage(String msg) throws IOException {

		System.out.println("*****");
		dataOut.writeUTF(msg);
		System.out.println(msg);
		System.out.println(dataOut);
		dataOut.flush();

		System.out.println("+++++");
		return null;

		// return dataIn.readUTF();
	}

	public void close() {
		try {
			dataOut.close();
			dataIn.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
