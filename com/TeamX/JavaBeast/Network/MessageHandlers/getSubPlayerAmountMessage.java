package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;

public class getSubPlayerAmountMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getSubPlayerAmount")){
            Main.getTeamXServer().StrToMain("setPlayerAmount "+ Main.getTeamXServer().getServerName()+" "+ Bukkit.getOnlinePlayers().size());
        }
    }
}
