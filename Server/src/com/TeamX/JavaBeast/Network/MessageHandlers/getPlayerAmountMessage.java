package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;

public class getPlayerAmountMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getPlayerAmount")){

            if(!client.isSubServer()){

                if(args.length == 1){
                    if(client.permissions.contains("TeamX.get.playerAmount")) {
                        client.sendStrMessage("setPlayerAmount " + Main.getInstance().getData().getAmountOfOnlinePlayers());
                    }else
                        client.sendStrMessage("code 203");
                }else if(args.length == 2){
                    if(client.permissions.contains("TeamX.get.playerAmountOf")){
                        if(Main.getInstance().getData().serverPlayerAmount.containsKey(args[1])) {
                            client.sendStrMessage("setPlayerAmount " + args[1] + " " + Main.getInstance().getData().getAmountOfPlayersOn(args[1]));
                        }else if(Main.getTeamXServer().getServerName().equals(args[1])){
                            client.sendStrMessage("setPlayerAmount "+ args[1]+" "+ Bukkit.getOnlinePlayers().size());
                        }else
                            client.sendStrMessage("code 303 server_not_found");
                    }else
                        client.sendStrMessage("code 203");
                }else
                    client.sendStrMessage("code 302");

            }else
                client.sendStrMessage("code 202");

        }
    }
}
