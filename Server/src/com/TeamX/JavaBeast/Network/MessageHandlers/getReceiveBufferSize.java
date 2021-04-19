package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getReceiveBufferSize implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getReceiveBufferSize")){
            client.sendStrMessage("setReceiveBufferSize "+ Main.getTeamXServer().getReceiveBufferSize());
        }
    }
}
