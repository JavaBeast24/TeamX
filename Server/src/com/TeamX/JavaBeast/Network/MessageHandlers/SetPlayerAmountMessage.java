package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Broadcaster;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;


public class SetPlayerAmountMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("setPlayerAmount")){
            if(client.isSubServer()){
                try{

                    if (args.length == 3) {

                        String server = args[1];
                        int players = Integer.parseInt(args[2]);

                        Main.getInstance().getData().serverPlayerAmount.remove(server);
                        Main.getInstance().getData().serverPlayerAmount.put(server, players);

                        Broadcaster.BroadCastPlayers();

                        client.sendStrMessage("code 0");
                    }else
                        client.sendStrMessage("code 302");

                }catch(NumberFormatException exception){
                    client.sendStrMessage("code 301");
                }
            }else
                client.sendStrMessage("code 201");
        }
    }
}
