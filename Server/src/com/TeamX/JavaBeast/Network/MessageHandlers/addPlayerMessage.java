package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Broadcaster;
import com.TeamX.JavaBeast.Network.Data;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

import java.util.ArrayList;
import java.util.List;

public class addPlayerMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {

        if(args[0].equals("addPlayer")){

            if(client.isSubServer()){

                if(args.length == 2){


                    Data data = Main.getInstance().getData();

                    List<String> current;

                    if(data.getPlayersOn(client.getName()) != null) {
                        current = data.getPlayersOn(client.getName());
                    }else{
                        current = new ArrayList<>();
                    }
                    current.add(args[1]);

                    data.serverPlayers.remove(client.getName());
                    data.serverPlayers.put(client.getName(), current);

                    data.serverPlayerAmount.remove(client.getName());
                    data.serverPlayerAmount.put(client.getName(), current.size());

                    Broadcaster.BroadCastPlayers();

                    data.register(args[1], client.getName());

                    Broadcaster.BroadCastRegister();

                    client.sendStrMessage("code 0");
                }else
                    client.sendStrMessage("code 302");

            }else
                client.sendStrMessage("code 201");

        }
    }
}
