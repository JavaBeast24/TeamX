package com.JavaBeast.test.Client;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//create new scanner to read from console
		Scanner scanner = new Scanner(System.in);
		
		
		//read server ip:port from console
		System.out.println("ip:");
		String server = scanner.nextLine();
		
		
		//read username from console
		System.out.println("username:");
		String username = scanner.nextLine();
		
		
		//read password from console
		System.out.println("password:");
		String password = scanner.nextLine();
		
		//close the scanner we don't need it anymore
		scanner.close();
		
		//split the server on ':' to get ip and port
		String[] server_data = server.split(":");
		String ip = server_data[0];
		int port = Integer.parseInt(server_data[1]);
		
		
		//try to connect to the server
		if(Connection.tryConnect(ip, port, username, password)) {
			
			//print out 'connected!' if connection was established
			System.out.println("connected!");
			
			
		}else {
			
			//print out 'failed to connect!' if connection failed
			System.out.println("failed to connect!");
			
		}
	}
	
}
