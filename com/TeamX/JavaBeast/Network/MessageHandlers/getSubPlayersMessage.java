package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class getSubPlayersMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getSubPlayers")){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setSupPlayers "+ Main.getTeamXServer().getServerName()+" ");

            for(Player player: Bukkit.getOnlinePlayers()){
                stringBuilder.append(player.getName()+";");
            }

            Main.getTeamXServer().StrToMain(stringBuilder.toString());
        }
    }
}
