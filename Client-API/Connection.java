package com.TeamX.JavaBeast.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Connection {
	
	private static Socket socket;
	private static boolean isRunning = true;
	
	public static boolean tryConnect(String ip, int port, String username, String password) {
		try {
			socket = new Socket(ip, port);
		}catch(Exception exception) {
			return false;
		}
		return tryLogin(username, password);
	}
	
	private static boolean tryLogin(String username, String password) {
		sendStr("login "+username+" "+password);
		if(waitForAnswer().equals("code 0/")) {
			listen();
			return true;
		}else {
			isRunning = false;
			try {
				socket.close();
			} catch (IOException e) {
			}
			return false;
		}
	}
	
	private static String waitForAnswer() {
		try {
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			
			while(!(inputStream.available() > 0)) {
				Thread.sleep(10);
			}
			
			byte[] msg = new byte[inputStream.available()];
			inputStream.read(msg);
			
			
			return new String(msg);
			}catch(Exception exception) {
				return "";
			}
	}
	
	private static void listen() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				DataInputStream inputStream = null;
				try {
					inputStream = new DataInputStream(socket.getInputStream());
				}catch(Exception exception) {
					System.out.println("err");
					return;
				}
				
				while(isRunning) {
					
					try {
					if(!(inputStream.available() > 0)) {
						Thread.sleep(10);
					}
					
					if(inputStream.available() > 0) {
						byte[] msg = new byte[inputStream.available()];
						inputStream.read(msg);
						
						String[] msgStrings = new String(msg).split("/");
						
						for(String _msg:msgStrings) {
							handleMessage(_msg.getBytes());
						}
					}

						
					}catch(Exception exception) {
						exception.printStackTrace();
					}
				}
				
			}
		});
		
		thread.start();
	}
	
	private static List<MessageHandler> handlers = new ArrayList<>();
	
	private static void handleMessage(byte[] msg) {
		for(MessageHandler handler:handlers) {
			handler.handle(new String(msg), msg);
		}
	}
	
	public static void addHandler(MessageHandler handler) {
		handlers.add(handler);
	}
	
	public static boolean sendStr(String msg) {
		try {
			
			msg+="/";
			
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataOutputStream.write(msg.getBytes());
			dataOutputStream.flush();
			
			
			return true;
		}catch(Exception exception) {
			return false;
		}
	}
	
}
