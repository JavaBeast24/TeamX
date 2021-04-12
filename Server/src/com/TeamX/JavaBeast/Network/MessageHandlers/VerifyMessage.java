package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VerifyMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("verify")){
            if(args.length == 2){
                Player player = Bukkit.getPlayer(args[1]);

                if(player != null){
                    player.sendMessage("[§bTeamX§7]§a somebody is trying to log in. if this is you please use /verify");
                }

            }else
                Main.getTeamXServer().StrToMain("code 302");
        }
    }
}
