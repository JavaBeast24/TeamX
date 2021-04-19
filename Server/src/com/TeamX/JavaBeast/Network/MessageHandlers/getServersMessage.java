package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getServersMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {

        if(args[0].equals("getServers")){

            if(!Main.getTeamXServer().isSubServer()){

                 StringBuilder stringBuilder = new StringBuilder();
                 stringBuilder.append("setServers ");

                 stringBuilder.append(Main.getTeamXServer().getServerName()+";");
                 for(Client server:Main.getTeamXServer().subServer){
                     stringBuilder.append(server.getName()+";");
                 }


                 client.sendStrMessage(stringBuilder.toString());
            }

        }

    }
}
