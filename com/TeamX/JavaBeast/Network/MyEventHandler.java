package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Events.ClientConnectEvent;
import com.TeamX.JavaBeast.Events.ClientRegisterAsSubServerEvent;
import com.TeamX.JavaBeast.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyEventHandler implements Listener {

    @EventHandler
    public void onRegisterAsSubServer(ClientRegisterAsSubServerEvent event){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                event.getClient().sendStrMessage("getSubPlayers");
            }
        }, 1L);
    }

    @EventHandler
    public void onClientConnect(ClientConnectEvent event){
        event.getClient().permissions.add("TeamX.get.playerAmount");
        event.getClient().permissions.add("TeamX.get.players");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(Main.getTeamXServer().isSubServer()){
            Main.getTeamXServer().StrToMain("addPlayer "+event.getPlayer().getName());
        }
    }

}
