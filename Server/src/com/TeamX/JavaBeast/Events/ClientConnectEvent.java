package com.TeamX.JavaBeast.Events;

import com.TeamX.JavaBeast.Server.Client;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClientConnectEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled = false;

    private final Client client;

    public ClientConnectEvent(Client client){
        this.client = client;
    }

    public Client getClient(){
        return client;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }
}
