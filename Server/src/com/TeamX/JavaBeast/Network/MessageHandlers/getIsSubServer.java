package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getIsSubServer implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getIsSubServer")){
            if(args.length == 1){
                client.sendStrMessage("setIsSubServer "+Main.getTeamXServer().getServerName()+" false");
            }else if(args.length == 2){
                String server = args[1];

                if(server.equals(Main.getTeamXServer().getServerName())){
                    client.sendStrMessage("setIsSubServer "+server+" false");
                }else{
                    boolean exists = false;

                    for(Client c:Main.getTeamXServer().subServer){
                        if(c.getName().equals(server)){
                            exists = true;
                        }
                    }

                    if(!exists){
                        client.sendStrMessage("setIsSubServer "+server+" -");
                    }else
                        client.sendStrMessage("setIsSubServer "+server+" true");
                }

            }
        }
    }
}
