package com.TeamX.JavaBeast.Minecraft;

import com.TeamX.JavaBeast.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class AccountCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(args.length == 1){

                FileConfiguration configuration = YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder() + "/accounts.yml"));
                configuration.set(player.getName()+".password", args[0]);
                try {
                    configuration.save(Main.getInstance().getDataFolder()+"/accounts.yml");
                } catch (IOException exception) {
                }

                player.sendMessage("[§bTeamX§7]§a account created!");

            }else
                sender.sendMessage("[§bTeamX§7]§4 usage: /account <password>");

        }else
            sender.sendMessage("[§bTeamX§7]§4 Only players can use this command.");

        return false;
    }
}
