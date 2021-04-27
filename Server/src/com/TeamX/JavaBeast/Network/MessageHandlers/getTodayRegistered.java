package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getTodayRegistered implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getTodayRegistered")){
            if(args.length == 1){
                client.sendStrMessage("setTodayRegistered "+Main.getTeamXServer().getServerName()+" "+ Main.getInstance().getData().getRegisteredToday().size());
            }else if(args.length == 2){
                client.sendStrMessage("setTodayRegistered "+args[1]+" "+Main.getInstance().getData().getRegisteredTodayOf(args[1]).size());
            }
        }
    }
}
