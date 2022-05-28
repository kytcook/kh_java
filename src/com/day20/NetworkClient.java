package com.day20;

import java.net.InetAddress;
import java.net.Socket;

public class NetworkClient {
	public void client_connect() {
		int port = 2055;
		String serverIP = "127.0.0.1";
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();// 자기자신이 호스트,클라이언트
			Socket socket = new Socket(serverIP, port);
			System.out.println("serverIP " + serverIP);
			System.out.println("NetworkClient socket " + socket);
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		NetworkClient nc = new NetworkClient();
		nc.client_connect();
	}

}
