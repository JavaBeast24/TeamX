package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class setPort implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("setPort")){
            if(args.length == 2){
                Main.getInstance().getData().serverPorts.put(client.getName(), args[1]);
                client.sendStrMessage("code 0");
            }
        }
    }
}
