package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;

public class stopNetworkMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("stopnetwork")) {
            if(Main.getTeamXServer().isSubServer()) {
                Bukkit.getServer().dispatchCommand(Main.getCmd(), "stop");
            }else if(client.permissions.contains("TeamX.cmd.stop")){
                for(Client c:Main.getTeamXServer().subServer){
                    c.sendStrMessage("stopnetwork");
                }

                Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().dispatchCommand(Main.getCmd(), "stop");
                    }
                }, 5L);
            }
        }
    }
}
