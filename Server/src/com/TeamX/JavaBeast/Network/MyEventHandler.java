package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Events.ClientRegisterAsSubServerEvent;
import com.TeamX.JavaBeast.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MyEventHandler implements Listener {

    @EventHandler
    public void onRegisterAsSubServer(ClientRegisterAsSubServerEvent event){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                event.getClient().sendStrMessage("getSubPlayers");
                event.getClient().sendStrMessage("getMaximum");
            }
        }, 1L);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(Main.getTeamXServer().isSubServer()){
            Main.getTeamXServer().StrToMain("addPlayer "+event.getPlayer().getName());
        }else{
            Broadcaster.BroadCastPlayers();
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        if(Main.getTeamXServer().isSubServer()){
            Main.getTeamXServer().StrToMain("removePlayer "+event.getPlayer().getName());
        }else{
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    Broadcaster.BroadCastPlayers();
                }
            }, 5L);
        }
    }

}
