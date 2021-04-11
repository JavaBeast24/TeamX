package com.TeamX.JavaBeast.Events;

import com.TeamX.JavaBeast.Server.Client;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.nio.charset.StandardCharsets;

public class MessageReceiveEvent extends Event {


    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final Client client;

    private String message;
    private byte[] byteMessage;
    private String[] args;

    public MessageReceiveEvent(Client client, String strMessage, byte[] byteMessage, String[] args){
        this.client = client;
        this.byteMessage = byteMessage;
        this.message = strMessage;
        this.args = args;
    }

    public Client getClient(){
        return client;
    }

    public String getMessage(){
        return message;
    }

    public byte[] getByteMessage(){
        return byteMessage;
    }

    public String[] getArgs(){
        return  args;
    }

    public void setMessage(String message){
        this.message = message;
        this.args = this.message.split(" ");
        this.byteMessage = this.message.getBytes(StandardCharsets.UTF_8);
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

}
