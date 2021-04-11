package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Events.ClientConnectEvent;
import com.TeamX.JavaBeast.Events.ClientRegisterAsSubServerEvent;
import com.TeamX.JavaBeast.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventHandler implements Listener {

    @org.bukkit.event.EventHandler
    public void onRegisterAsSubServer(ClientRegisterAsSubServerEvent event){
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                event.getClient().sendStrMessage("getSubPlayerAmount");
            }
        }, 1L);
    }

    @org.bukkit.event.EventHandler
    public void onClientConnect(ClientConnectEvent event){
        event.getClient().permissions.add("TeamX.get.playerAmount");
    }

}
