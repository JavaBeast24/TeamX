package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Account {

    private static FileConfiguration config = YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder() + "/accounts.yml"));
    public static HashMap<String, Client> waiting_clients = new HashMap<>();

    private static void saveConfig(){
        try {
            config.save(new File(Main.getInstance().getDataFolder()+"/accounts.yml"));
        } catch (IOException exception) {
        }
    }

    public static boolean tryLogin(String username, String password){
        if(config.contains(username+".password")){
            if(config.getString(username+".password").equals(password)){
                return true;
            }else
                return false;
        }else
            return false;
    }

    public static List<String> getPermissions(String username){
        return config.getStringList(username+".permissions");
    }

    public static void setPermissions(List<String> perms, String username){
        config.set(username+".permissions", perms);
        saveConfig();
    }
}
