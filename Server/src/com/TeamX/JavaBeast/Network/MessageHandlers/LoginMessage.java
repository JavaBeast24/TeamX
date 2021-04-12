package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Network.Account;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class LoginMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("login")){

            if(!client.isSubServer()) {
                if (args.length == 3) {

                    String username = args[1];
                    String password = args[2];

                    if(Main.getTeamXServer().isOnlyAcceptOnlineUsers()||Main.getTeamXServer().isHasToVerify()){
                        if(!Main.getInstance().getData().getPlayers().contains(username)){
                            client.sendStrMessage("code 204");
                            return;
                        }
                    }

                    if(!Account.tryLogin(username, password)){
                        client.sendStrMessage("code 205");
                        return;
                    }

                    if(Main.getTeamXServer().isHasToVerify()){
                        Main.getTeamXServer().StrToAllSubServers("verify "+username);
                        Account.waiting_clients.put(username, client);
                        return;
                    }

                    client.permissions = Account.getPermissions(username);
                    client.sendStrMessage("code 0");
                }
            }

        }
    }
}
