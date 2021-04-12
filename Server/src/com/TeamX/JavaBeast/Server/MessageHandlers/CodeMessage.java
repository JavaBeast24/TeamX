package com.TeamX.JavaBeast.Server.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class CodeMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("code")){
            if(args.length > 1){

                String code = args[1];

                switch(code){
                    case "0":
                        Main.getCmd().sendMessage("[§bTeamX§7]§a Command executed.");
                        Main.getTeamXServer().Log("Command executed.");
                        break;
                    case "101":
                        Main.getCmd().sendMessage("[§bTeamX§7]§4 subServer connection refused (no subServers allowed)");
                        Main.getTeamXServer().Log("subServer connection refused (no subServers allowed)");
                        break;
                    case "102":
                        Main.getCmd().sendMessage("[§bTeamX§7]§4 subServer connection refused (name already used)");
                        Main.getTeamXServer().Log("subServer connection refused (name already used)");
                        break;
                }

                if(args.length == 3){
                    Main.getCmd().sendMessage("[§bTeamX§7]§4 Additional info: \n  "+args[2]);
                }

            }
        }
    }
}
