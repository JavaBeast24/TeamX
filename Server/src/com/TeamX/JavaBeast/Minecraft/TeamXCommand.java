package com.TeamX.JavaBeast.Minecraft;

import com.TeamX.JavaBeast.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class TeamXCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 2){

            FileConfiguration config = Main.getInstance().getConfig();

            switch (args[0]){
                case "port":
                    config.set("port", Integer.parseInt(args[1]));
                    break;
                case "acceptSubServers":
                    config.set("acceptSubServers", Boolean.parseBoolean(args[1]));
                    break;
                case "onlyAcceptOnlineUsers":
                    config.set("onlyAcceptOnlineUsers", Boolean.parseBoolean(args[1]));
                    break;
                case "hasToVerify":
                    config.set("hasToVerify", Boolean.parseBoolean(args[1]));
                    break;
                case "createLog":
                    config.set("createLog", Boolean.parseBoolean(args[1]));
                    break;
                case "startExternal":
                    config.set("startExternal", Boolean.parseBoolean(args[1]));
                    break;
                case "throttle":
                    config.set("throttle", Long.parseLong(args[1]));
                    break;
                case "receiveBufferSize":
                    config.set("receiveBufferSize", Integer.parseInt(args[1]));
                    break;
                case "isSubServer":
                    config.set("isSubServer", Boolean.parseBoolean(args[1]));
                    break;
                case "mainServer":
                    config.set("mainServer", args[1]);
                    break;
                case "serverName":
                    config.set("serverName", args[1]);
                    break;
            }

            sender.sendMessage("[§bTeamX§7]§a reload the server to apply changes!");

            Main.getInstance().saveConfig();

        }else if(args.length == 1){

            FileConfiguration config = Main.getInstance().getConfig();

            switch (args[0]){
                case "port":
                    sender.sendMessage("[§bTeamX§7]§a port="+config.get("port"));
                    break;
                case "acceptSubServers":
                    sender.sendMessage("[§bTeamX§7]§a acceptSubServers="+config.get("acceptSubServers"));
                    break;
                case "onlyAcceptOnlineUsers":
                    sender.sendMessage("[§bTeamX§7]§a onlyAcceptOnlineUsers="+config.get("onlyAcceptOnlineUsers"));
                    break;
                case "hasToVerify":
                    sender.sendMessage("[§bTeamX§7]§a hasToVerify="+config.get("hasToVerify"));
                    break;
                case "createLog":
                    sender.sendMessage("[§bTeamX§7]§a createLog="+config.get("createLog"));
                    break;
                case "startExternal":
                    sender.sendMessage("[§bTeamX§7]§a startExternal="+config.get("startExternal"));
                    break;
                case "throttle":
                    sender.sendMessage("[§bTeamX§7]§a throttle="+config.get("throttle"));
                    break;
                case "receiveBufferSize":
                    sender.sendMessage("[§bTeamX§7]§a receiveBufferSize="+config.get("receiveBufferSize"));
                    break;
                case "isSubServer":
                    sender.sendMessage("[§bTeamX§7]§a isSubServer="+config.get("isSubServer"));
                    break;
                case "mainServer":
                    sender.sendMessage("[§bTeamX§7]§a mainServer="+config.get("mainServer"));
                    break;
                case "serverName":
                    sender.sendMessage("[§bTeamX§7]§a serverName="+config.get("serverName"));
                    break;
            }
        }else
            sender.sendMessage("[§bTeamX§7]§4 Usage: /teamx <key> <vert>");

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        List<String> list = new ArrayList<>();

        if(args.length == 1){
            list.add("port");
            list.add("acceptSubServers");
            list.add("onlyAcceptOnlineUsers");
            list.add("hasToVerify");
            list.add("createLog");
            list.add("startExternal");
            list.add("throttle");
            list.add("receiveBufferSize");
            list.add("isSubServer");
            list.add("mainServer");
            list.add("serverName");
        }else if(args.length == 2){
            switch (args[0]){
                case "acceptSubServers":
                case "createLog":
                case "onlyAcceptOnlineUsers":
                case "hasToVerify":
                case "startExternal":
                case "isSubServer":
                    list.add("true");
                    list.add("false");
                    break;
                case "mainServer":
                    list.add("127.0.0.1");
                    list.add("localhost");
            }
        }

        return list;
    }
}
