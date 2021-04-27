package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getTodayJoined implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getTodayJoined")){

            if(args.length == 1){
                client.sendStrMessage("setTodayJoined "+ Main.getTeamXServer().getServerName()+" "+Main.getInstance().getData().getTodayJoined().size());
            }else if(args.length == 2){
                client.sendStrMessage("setTodayJoined "+args[1]+" "+Main.getInstance().getData().getTodayJoinedOf(args[1]).size());
            }

        }
    }
}
