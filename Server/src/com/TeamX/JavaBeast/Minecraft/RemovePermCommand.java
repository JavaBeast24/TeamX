package com.TeamX.JavaBeast.Minecraft;

import com.TeamX.JavaBeast.Network.Account;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class RemovePermCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 1){
            if(sender instanceof Player){
                Player player = (Player) sender;

                List<String> new_permissions = Account.getPermissions(player.getName());
                new_permissions.remove(args[0]);

                Account.setPermissions(new_permissions, player.getName());

                player.sendMessage("[§bTeamX§7]§a removed permission.");
            }else
                sender.sendMessage("[§bTeamX§§7]§4 Only players can use this command.");
        }else
            sender.sendMessage("[§bTeamX§7]§4 usage: /removePerm <permission>");

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();

        if(args.length == 1){
            list = Account.getPermissions(sender.getName());
        }

        return list;
    }
}
