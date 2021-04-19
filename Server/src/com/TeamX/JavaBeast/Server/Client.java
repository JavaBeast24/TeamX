package com.TeamX.JavaBeast.Server;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Account;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public final Socket socket;
    private String name;
    private boolean isSubServer;

    private boolean isRunning = true;

    private Thread listenerThread;

    private final Client self;

    private final int receiveBufferSize;

    public List<String> permissions = new ArrayList<>();

    public Client(Socket socket, String name, boolean isSubServer, int receiveBufferSize) {
        this.socket = socket;
        this.name = name;
        this.isSubServer = isSubServer;
        this.receiveBufferSize = receiveBufferSize;
        this.self = this;

        Receive();
    }

    public boolean isSubServer() {
        return isSubServer;
    }

    public void setSubServer(boolean isSubServer) {
        this.isSubServer = isSubServer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void Receive() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                DataInputStream dataInputStream = null;

                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                } catch (Exception exception) {
                    Main.getCmd().sendMessage("[§bTeamX§7] §4Error while creating inputStream : " + exception.getMessage() + " -> disconnecting client.");
                    Main.getTeamXServer().Log("Error while creating inputStream : " + exception.getMessage() + " -> disconnecting client.");
                    stop();
                }

                while (isRunning) {
                    try {

                        try {

                            if (!(dataInputStream.available() > 0)) {
                                if (socket.isClosed()) {
                                    Main.getCmd().sendMessage("[§bTeamX§7]§4 Incorrect client quit! -> closing.");
                                    stop();
                                    break;
                                } else
                                    continue;
                            }

                            byte[] _bytes;

                            if (dataInputStream.available() < receiveBufferSize) {
                                _bytes = new byte[dataInputStream.available()];
                            } else
                                _bytes = new byte[receiveBufferSize];


                            dataInputStream.read(_bytes);

                            String msg = new String(_bytes);

                            String[] MSG = msg.split("/");

                            for(String s:MSG) {
                                Main.getCmd().sendMessage("[§bTeamX§7]§a Received message : " + s);
                                Main.getTeamXServer().Log("Received message : " + s);

                                Main.getTeamXServer().received(s.getBytes(StandardCharsets.UTF_8), s, self);
                            }
                        }catch(NullPointerException exception){

                        }
                    } catch (Exception exception) {
                        Main.getCmd().sendMessage("[§bTeamX§7] §4Error while receiving message : " + exception.getMessage() + " -> disconnecting client.");
                        Main.getTeamXServer().Log("Error while receiving message : " + exception.getMessage() + " -> disconnecting client.");
                        stop();
                        return;
                    }
                }
            }
        });

        thread.start();
        this.listenerThread = thread;
    }

    public boolean sendStrMessage(String msg){
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write((msg+"/").getBytes(StandardCharsets.UTF_8));
            outputStream.flush();

            Main.getCmd().sendMessage("[§bTeamX§7]§a sent: "+msg);
            return true;
        }catch(Exception exception){
            Main.getCmd().sendMessage("[§bTeamX§7] §4Error while sending message : "+exception.getMessage()+" -> disconnecting client");
            Main.getTeamXServer().Log("Error while sending message : "+exception.getMessage()+" -> disconnecting client");
            stop();
            return false;
        }
    }

    public void stop() {

        this.isRunning = false;

        listenerThread.interrupt();

        try {
            socket.close();
        } catch (IOException exception) {
        }

        Main.getCmd().sendMessage("[§bTeamX§7]§a client " + this.getName() + " disconnected.");
        Main.getTeamXServer().Log("client " + this.getName() + " disconnected.");

        Main.getTeamXServer().clients.remove(this);
        Main.getTeamXServer().CLIENTS.remove(this);
        Main.getTeamXServer().subServer.remove(this);
    }

}
