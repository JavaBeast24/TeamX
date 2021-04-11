package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Broadcaster;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

import java.util.Arrays;

public class SetPlayersMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("setPlayers")){
            if(client.isSubServer()){

                if(args.length == 3){

                    String server = args[1];
                    String[] playerNames = args[2].split(";");

                    Main.getInstance().getData().serverPlayers.put(server, Arrays.asList(playerNames));

                    Broadcaster.BroadCastPlayers();

                    client.sendStrMessage("code 0");
                }else
                    client.sendStrMessage("code 302");

            }else
                client.sendStrMessage("code 201");
        }
    }
}
