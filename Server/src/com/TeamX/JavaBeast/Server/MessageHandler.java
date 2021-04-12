package com.TeamX.JavaBeast.Server;

public interface MessageHandler {

    void onReceive(byte[] byteMessage, String strMessage, String[] args,Client client);

}
