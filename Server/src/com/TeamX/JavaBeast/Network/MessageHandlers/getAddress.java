package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

import java.net.InetSocketAddress;


public class getAddress implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("getAddress")){

            if(!Main.getTeamXServer().isSubServer()){
                if(args.length == 1) {
                    client.sendStrMessage("setAddress "+Main.getTeamXServer().getServerName()+" " + client.socket.getLocalAddress().toString()+":"+Main.getInstance().getData().getPort());

                }else if(args.length == 2){
                    String address = "";

                    if(args[1].equals(Main.getTeamXServer().getServerName())){
                        address = client.socket.getLocalAddress().toString();
                    }

                    for(Client client1:Main.getTeamXServer().subServer) {
                        if (client1.getName().equals(args[1])) {
                            address=(((InetSocketAddress) client1.socket.getRemoteSocketAddress()).getAddress()).toString().replace("/","");
                        }
                    }

                    if(address.equals("127.0.0.1")){
                        address = client.socket.getLocalAddress().toString();
                    }

                    address+=":"+Main.getInstance().getData().getPortOf(args[1]);

                    client.sendStrMessage("setAddress "+args[1]+" "+address.replace("/",""));
                }
            }

        }
    }
}
