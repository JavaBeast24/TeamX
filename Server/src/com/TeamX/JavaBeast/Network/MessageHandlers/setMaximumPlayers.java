package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Broadcaster;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class setMaximumPlayers implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("setMaximum")){

            if(args.length == 2){
                Main.getInstance().getData().maximumPlayers.remove(client.getName());
                Main.getInstance().getData().maximumPlayers.put(client.getName(), Integer.parseInt(args[1]));
                Broadcaster.BroadCastMaximum();
            }

        }
    }
}
