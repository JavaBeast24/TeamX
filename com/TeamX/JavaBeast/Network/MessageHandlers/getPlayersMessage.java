package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Data;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class getPlayersMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getPlayers")){

            if(client.permissions.contains("TeamX.get.players")){

                Data data = Main.getInstance().getData();

                if(args.length == 1){

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setPlayers ");

                    for(String s:data.getPlayers()){
                        stringBuilder.append(s+";");
                    }

                    client.sendStrMessage(stringBuilder.toString());
                }else if(args.length == 2){

                    if(data.getPlayersOn(args[1]) == null){
                        client.sendStrMessage("code 303 server_not_found");
                        return;
                    }

                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setPlayers "+args[1]+" ");

                    for(String s:data.getPlayersOn(args[1])){
                        stringBuilder.append(s+";");
                    }

                }else
                    client.sendStrMessage("code 302");

            }else
                client.sendStrMessage("code 203");

        }
    }
}
