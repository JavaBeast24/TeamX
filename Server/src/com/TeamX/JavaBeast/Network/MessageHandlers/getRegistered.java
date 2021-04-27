package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getRegistered implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getRegistered")){
            if(args.length == 1){
                client.sendStrMessage("setRegistered "+ Main.getTeamXServer().getServerName()+" "+Main.getInstance().getData().getRegistered().size());
            }else if(args.length == 2){
                client.sendStrMessage("setRegistered "+args[1]+" "+Main.getInstance().getData().getRegisteredOf(args[1]).size());
            }
        }
    }
}
