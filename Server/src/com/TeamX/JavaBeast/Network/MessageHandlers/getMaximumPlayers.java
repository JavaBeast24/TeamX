package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;

public class getMaximumPlayers implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getMaximum")){

            if(!Main.getTeamXServer().isSubServer()) {
                if (args.length == 1) {
                    if (client != null) {
                        client.sendStrMessage("setMaximum " + Main.getInstance().getData().getMaximum());
                    }
                } else if (args.length == 2) {
                    if (client != null) {
                        client.sendStrMessage("setMaximum "+args[1]+" "+Main.getInstance().getData().getMaximumOf(args[1]));
                    }
                }
            }else{
                if(args.length == 1){
                    Main.getTeamXServer().StrToMain("setMaximum "+ Bukkit.getServer().getMaxPlayers());
                }
            }

        }
    }
}
