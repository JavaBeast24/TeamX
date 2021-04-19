package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Server;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {

    private final Server server;

    public final HashMap<String, Integer> serverPlayerAmount = new HashMap<>();
    public final HashMap<String, List<String>> serverPlayers = new HashMap<>();
    public final HashMap<String, Integer> maximumPlayers = new HashMap<>();
    public final HashMap<String, String> serverPorts = new HashMap<>();

    public Data(Server server){
        this.server = server;
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
    public List<Player> getRegistered(){
        //TODO: load registered players from registered.yml
        return null;
    }
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
    public List<Player> getRegisteredOf(String server){
        //TODO: load registered players of the given server from registered.yml
        return null;
    }
    public String getPortOf(String server){

        if(server.equals(Main.getTeamXServer().getServerName())){
            return String.valueOf(Main.getInstance().getServer().getPort());
        }

        return serverPorts.get(server);
    }
}
