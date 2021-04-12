package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Network.Account;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class VerifiedMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("verified")){
            if(args.length == 2){

                if(Account.waiting_clients.containsKey(args[1])){
                    Account.waiting_clients.get(args[1]).permissions = Account.getPermissions(args[1]);
                    Account.waiting_clients.remove(args[1]);
                }

            }else
                client.sendStrMessage("code 302");
        }
    }
}
