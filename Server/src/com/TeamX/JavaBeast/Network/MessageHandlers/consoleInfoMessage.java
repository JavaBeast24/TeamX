package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Network.Broadcaster;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class consoleInfoMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("consoleInfo")){
            if(args.length == 3){

                Broadcaster.BroadCastConsoleInfo(args[2], args[1]);

            }
        }
    }
}
