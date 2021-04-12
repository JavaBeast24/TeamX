package com.TeamX.JavaBeast.Minecraft;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Account;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AddPermCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 1){
            if(sender instanceof Player){
                Player player = (Player) sender;

                List<String> new_permissions = Account.getPermissions(player.getName());
                new_permissions.add(args[0]);

                Account.setPermissions(new_permissions, player.getName());

                player.sendMessage("[§bTeamX§7]§a added permission.");
            }else
                sender.sendMessage("[§bTeamX§§7]§4 Only players can use this command.");
        }else
            sender.sendMessage("[§bTeamX§7]§4 usage: /addPerm <permission>");

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();

        if(args.length == 1){
            list.add("TeamX.get.players");
            list.add("TeamX.get.playerAmount");
            list.add("TeamX.get.playerAmountOf");
        }

        return list;
    }
}
