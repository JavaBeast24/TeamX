package com.TeamX.JavaBeast.Server.MessageHandlers;

import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class StopMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("stop")) {
            if (client != null) {
                client.stop();
            }
        }
    }
}
