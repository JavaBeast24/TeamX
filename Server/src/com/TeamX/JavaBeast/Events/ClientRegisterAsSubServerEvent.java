package com.TeamX.JavaBeast.Events;

import com.TeamX.JavaBeast.Server.Client;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.nio.charset.StandardCharsets;

public class ClientRegisterAsSubServerEvent extends Event {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private Client client;
    private String name;

    public ClientRegisterAsSubServerEvent(Client client, String name){
        this.name = name;
        this.client = client;
    }


    public Client getClient(){
        return client;
    }

    public String getName(){
        return name;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
