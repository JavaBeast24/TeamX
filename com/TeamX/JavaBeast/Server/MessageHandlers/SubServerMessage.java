package com.TeamX.JavaBeast.Server.MessageHandlers;

import com.TeamX.JavaBeast.Events.ClientRegisterAsSubServerEvent;
import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;
import org.bukkit.Bukkit;

public class SubServerMessage implements MessageHandler {

    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(strMessage.startsWith("subServer")){
            if(Main.getTeamXServer().isAcceptSubServers()) {
                client.setSubServer(true);

                for(Client c:Main.getTeamXServer().subServer){
                    if(c.getName().equals(args[1])){
                        if(c.sendStrMessage("ping")) {
                            client.sendStrMessage("code 102");
                            client.stop();
                            Main.getCmd().sendMessage("[§bTeamX§7]§4 subServer connection refused (server with that name already exist)");
                            Main.getTeamXServer().Log("subServer connection refused (server with that name already exist)");
                            return;
                        }
                    }
                }

                if(args[1].equals(Main.getTeamXServer().getServerName())){
                    client.sendStrMessage("code 102");
                    client.stop();
                    Main.getCmd().sendMessage("[§bTeamX§7]§4 subServer connection refused (server with that name already exist)");
                    Main.getTeamXServer().Log("subServer connection refused (server with that name already exist)");
                    return;
                }

                client.setName(args[1]);
                Main.getTeamXServer().subServer.add(client);
                Main.getTeamXServer().CLIENTS.remove(client);

                ClientRegisterAsSubServerEvent event = new ClientRegisterAsSubServerEvent(client, args[1]);
                Bukkit.getPluginManager().callEvent(event);

                client.sendStrMessage("code 0");
                Main.getCmd().sendMessage("[§bTeamX§7]§a subServer "+client.getName()+" is now connected!");
                Main.getTeamXServer().Log("subServer "+client.getName()+" is now connected!");
            }else{
                client.sendStrMessage("code 101");
                client.stop();
                Main.getCmd().sendMessage("[§bTeamX§7]§4 subServer connection refused (no subServers allowed)");
                Main.getTeamXServer().Log("subServer connection refused (no subServers allowed)");
            }
        }
    }
}
