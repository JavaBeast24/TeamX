package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;

public class ReloadNetworkMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("reloadnetwork")){
            if(Main.getTeamXServer().isSubServer()){
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Main.getInstance().getServer().dispatchCommand(Main.getInstance().getServer().getConsoleSender(), "rl");
                    }
                }, 50L);
            }else {
                Main.getTeamXServer().StrToAllClients("reloadnetwork");
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Main.getInstance().getServer().dispatchCommand(Main.getInstance().getServer().getConsoleSender(), "rl");
                    }
                }, 1L);
            }
        }
    }
}
