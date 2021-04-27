package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Events.ClientRegisterAsSubServerEvent;
import com.TeamX.JavaBeast.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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
            Main.getTeamXServer().StrToMain("consoleInfo "+Main.getTeamXServer().getServerName()+ " Player_"+event.getPlayer().getName()+"_joined_the_server.");
        }else{
            Broadcaster.BroadCastPlayers();
            Broadcaster.BroadCastConsoleInfo("Player "+event.getPlayer().getName()+" joined the game.", Main.getTeamXServer().getServerName());
            Main.getInstance().getData().register(event.getPlayer().getName(), Main.getTeamXServer().getServerName());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        if(Main.getTeamXServer().isSubServer()){
            Main.getTeamXServer().StrToMain("removePlayer "+event.getPlayer().getName());
            Main.getTeamXServer().StrToMain("consoleInfo "+Main.getTeamXServer().getServerName()+ " Player_"+event.getPlayer().getName()+"_left_the_server.");
        }else{
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    Broadcaster.BroadCastPlayers();
                    Broadcaster.BroadCastConsoleInfo("Player "+event.getPlayer().getName()+" left the game.", Main.getTeamXServer().getServerName());
                }
            }, 5L);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if(Main.getTeamXServer().isSubServer()){
            Main.getTeamXServer().StrToMain("consoleInfo "+Main.getTeamXServer().getServerName()+ " "+event.getPlayer().getName()+"_:_"+event.getMessage().replace(" ", "_"));
        }else{
            Broadcaster.BroadCastPlayers();
            Broadcaster.BroadCastConsoleInfo(event.getPlayer().getName()+" : "+event.getMessage(), Main.getTeamXServer().getServerName());
        }
    }

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent event){
        if(Main.getTeamXServer().isSubServer()){
            Main.getTeamXServer().StrToMain("consoleInfo "+Main.getTeamXServer().getServerName()+ " "+event.getPlayer().getName()+"_:_\\"+event.getMessage().replace("/", "").replace(" ", "_"));
        }else{
            Broadcaster.BroadCastPlayers();
            Broadcaster.BroadCastConsoleInfo(event.getPlayer().getName()+" : \\"+event.getMessage().replace("/", ""), Main.getTeamXServer().getServerName());
        }
    }

}
