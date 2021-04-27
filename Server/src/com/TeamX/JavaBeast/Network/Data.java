package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Server;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {

    private final Server server;

    public final FileConfiguration registered;

    public final HashMap<String, Integer> serverPlayerAmount = new HashMap<>();
    public final HashMap<String, List<String>> serverPlayers = new HashMap<>();
    public final HashMap<String, Integer> maximumPlayers = new HashMap<>();
    public final HashMap<String, String> serverPorts = new HashMap<>();

    public Data(Server server){
        this.server = server;
        registered = YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder()+"/registered.yml"));
    }

    public int getAmountOfOnlinePlayers(){
        int amount = 0;

        for(int val:serverPlayerAmount.values()){
            amount+=val;
        }

        amount+= Bukkit.getOnlinePlayers().size();

        return amount;
    }
    public List<String> getPlayers(){
        List<String> list = new ArrayList<>();

        for(List<String> l: serverPlayers.values()){
            list.addAll(l);
        }

        for(Player player:Bukkit.getOnlinePlayers()){
            list.add(player.getName());
        }

        return list;
    }
    public int getMaximum(){
        int maximum = 0;

        for(int i: maximumPlayers.values()){
            maximum+=i;
        }

        maximum+= Bukkit.getServer().getMaxPlayers();

        return maximum;
    }
    public List<String> getRegistered(){
        return registered.getStringList("registered");
    }
    public List<String> getRegisteredToday(){return registered.getStringList("registeredToday");}
    public List<String> getTodayJoined(){return registered.getStringList("joinedToday");}
    public String getPort(){
        return String.valueOf(Main.getInstance().getServer().getPort());
    }

    public int getAmountOfPlayersOn(String server){

        if(server.equals(Main.getTeamXServer().getServerName())){
            return Bukkit.getServer().getOnlinePlayers().size();
        }

        return serverPlayerAmount.get(server);
    }
    public List<String> getPlayersOn(String server){
        List<String> list = new ArrayList<>();

        if(server.equals(Main.getTeamXServer().getServerName())){
            for(Player player:Bukkit.getOnlinePlayers()){
                list.add(player.getName());
            }
        }else{
            list = serverPlayers.get(server);
        }

        return list;
    }
    public int getMaximumOf(String server){
        if(maximumPlayers.containsKey(server)){
            return maximumPlayers.get(server);
        }

        if(Main.getTeamXServer().getServerName().equals(server)){
            return Main.getInstance().getServer().getMaxPlayers();
        }

        return 0;
    }
    public List<String> getRegisteredOf(String server){
        return registered.getStringList("registered_."+server);
    }
    public List<String> getRegisteredTodayOf(String server){return registered.getStringList("registeredToday_."+server);}
    public List<String> getTodayJoinedOf(String server){
        return registered.getStringList("joinedToday_."+server);
    }
    public String getPortOf(String server){

        if(server.equals(Main.getTeamXServer().getServerName())){
            return String.valueOf(Main.getInstance().getServer().getPort());
        }

        return serverPorts.get(server);
    }


    public void register(String player, String server){
        if(!registered.getStringList("registered").contains(player)){
            List<String> players = registered.getStringList("registered");
            players.add(player);
            registered.set("registered", players);

            players = registered.getStringList("registeredToday");
            players.add(player);
            registered.set("registeredToday", players);

            players = registered.getStringList("joinedToday");
            players.add(player);
            registered.set("joinedToday", players);
        }

        List<String> _players = registered.getStringList("joinedToday");
        if(!_players.contains(player)){
            _players.add(player);
        }

        registered.set("joinedToday", _players);

        if(!registered.getStringList("registered_."+server).contains(player)){
            List<String> players = registered.getStringList("registered_."+server);
            players.add(player);
            registered.set("registered_."+server, players);

            players = registered.getStringList("registeredToday_."+server);
            players.add(player);
            registered.set("registeredToday_."+server, players);

            players = registered.getStringList("joinedToday_."+server);
            players.add(player);
            registered.set("joinedToday_."+server, players);
        }

        _players = registered.getStringList("joinedToday_."+server);
        if(!_players.contains(player)){
            _players.add(player);
        }

        registered.set("joinedToday_."+server, _players);

        try {
            registered.save(new File(Main.getInstance().getDataFolder()+"/registered.yml"));
        } catch (IOException exception) {
        }
    }
}
