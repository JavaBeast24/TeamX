package com.JavaBeast.test.Client.ConnectionWithBothSideCommunication;

import java.util.Scanner;

import com.JavaBeast.test.Client.Connection;
import com.JavaBeast.test.Client.MessageHandler;

/*
 * This project connects to the server, loggs in and
 * listens for consoleInfo like join, quit,
 * command and chat messages
 * 
 * given arguments in the consoleInfo message:
 * - args[0] = 'consoleInfo'
 * - args[1] = the server the message came from
 * - args[2] = the given message with ' ' replaced with '_'
 * 
 * 
 * error codes:
 * - 0 = command accepted
 * 
 * - 101 = no sub-servers are allowed
 * - 102 = subServer with that name already registered
 * 
 * - 201 = client needs to be sub-server
 * - 202 = client needs to be non-sub-server-client
 * - 203 = client missing permission
 * - 204 = client player needs to be online
 * - 205 = client login error
 * 
 * - 301 = wrong type of argument
 * - 302 = wrong length of arguments
 * - 303 = wrong argument
 *
 */
public class ConnectionWithBothSideCommunication {

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
			
			
			//start a new Console Reader
			new ConsoleListener();
			
			
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

class ErrorCodeMessage implements MessageHandler {

	@Override
	public void handle(String strMsg, byte[] byteMsg) {

		//check if we got the right message
		if(strMsg.startsWith("code")) {
			
			//split the received string
			String[] args = strMsg.split(" ");
			
			//args[0] = 'code'
			//args[1] = error code (example '0')
			
			String errorCode = args[1];
			
			//print out the error code
			System.out.println("back code: "+errorCode);
			
		}
		
	}
	
}

class ConsoleListener {
	
	public ConsoleListener() {
		
		//create a new scanner to read input from console
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		//start a new thread to let the program continue
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				//repeat infinity
				while(true) {
					
					//read next line from console
					String input = scanner.nextLine();
					
					//send the input to the server
					Connection.sendStr(input);
					
				}
				
			}
		}).start();
	}
	
}
