package com.JavaBeast.test.Client;

import java.util.Scanner;

/*
 * This project connects to the server, loggs in and
 * listens for consoleInfo like join, quit,
 * command and chat messages
 * 
 * given arguments in the consoleInfo message:
 * - args[0] = 'consoleInfo'
 * - args[1] = the server the message came from
 * - args[2] = the given message with ' ' replaced with '_'
 */
public class ConnectionWithMessageListener {

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
			//and we are logged in
			//the client should now automaticly listen for messages from the server
			System.out.println("connected!");
			
			
			//add a new MessageHandler to the connection
			//every added MessageHandler will be called when a message is received
			Connection.addHandler(new ConsoleInfoMessage());
			
		}else {
			
			//print out 'failed to connect!' if connection failed
			System.out.println("failed to connect!");
			
		}
	}
	
}

class ConsoleInfoMessage implements MessageHandler{

	@Override
	public void handle(String strMsg, byte[] byteMsg) {
		
		//check if we got the right message
		if(strMsg.startsWith("consoleInfo")) {
		
			
			//splitup the received string
			String[] args = strMsg.split(" ");
		 
			//args[0] = 'consoleInfo' 
			//args[1] = the server were the info came from
			//args[2] = executed command/sent message/join or quit info
			String info = args[2];
		
			//print the given info and replace all '_' with ' '
			//because every ' ' in a command will be replaced with '_'
			//therefore we have to replace it back
			System.out.println(info.replace("_", " "));
		}
		
	}
	
}
