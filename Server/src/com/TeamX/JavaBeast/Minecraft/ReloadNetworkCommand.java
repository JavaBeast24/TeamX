package com.TeamX.JavaBeast.Minecraft;

import com.TeamX.JavaBeast.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadNetworkCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 0){

            if(Main.getTeamXServer().isSubServer()){
               Main.getTeamXServer().StrToMain("reloadnetwork");
            }else {
                Main.getTeamXServer().StrToAllClients("reloadnetwork");
                Main.getInstance().getServer().dispatchCommand(Main.getInstance().getServer().getConsoleSender(), "rl");
            }

            sender.sendMessage("[§bTeamX§7]§a reloading network.");

        }else
            sender.sendMessage("[§bTeamX§7]§4 usage: /reloadnetwork");

        return false;
    }
}
