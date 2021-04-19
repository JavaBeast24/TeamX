package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getMainServer implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getMainServer")){
            if(!Main.getTeamXServer().isSubServer()){
                 client.sendStrMessage("setMainServer "+Main.getTeamXServer().getServerName()+" " + client.socket.getLocalAddress().toString()+":"+Main.getInstance().getData().getPort());
            }
        }
    }
}
