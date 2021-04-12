package com.TeamX.JavaBeast.Network;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;

public class Broadcaster {

    public static void BroadCastPlayers(){

        Data data = Main.getInstance().getData();

        for(Client client:Main.getTeamXServer().subServer){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setPlayers "+client.getName()+" ");



            if(data.getPlayersOn(client.getName()) != null) {
                for (String s:data.getPlayersOn(client.getName())) {
                    stringBuilder.append(s+";");
                }
            }

            for(Client c:Main.getTeamXServer().CLIENTS){
                if(c.permissions.contains("TeamX.get.players")){
                    System.out.println(c.getName());
                }
                if(c.permissions.contains("TeamX.get.playerAmountOf")){
                    c.sendStrMessage("setPlayerAmount "+client.getName()+" "+data.getAmountOfPlayersOn(client.getName()));
                }
            }
        }

        for(Client c:Main.getTeamXServer().CLIENTS){
            if(c.permissions.contains("TeamX.get.playerAmount")){
                c.sendStrMessage("setPlayerAmount "+data.getAmountOfOnlinePlayers());
            }
        }


    }

}
