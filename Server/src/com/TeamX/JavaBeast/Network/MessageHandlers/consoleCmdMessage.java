package com.TeamX.JavaBeast.Network.MessageHandlers;

import com.TeamX.JavaBeast.Main;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandler;

public class consoleCmdMessage implements MessageHandler {
    @Override
    public void onReceive(byte[] byteMessage, String strMessage, String[] args, Client client) {
        if(args[0].equals("consoleCmd")) {
            if (Main.getTeamXServer().isSubServer()) {
                if(args.length == 3) {
                    if (Main.getTeamXServer().getServerName().equals(args[1])) {
                        String cmd = args[2].replace("_", " ");
                        Main.getInstance().getServer().dispatchCommand(Main.getCmd(), cmd);

                        Main.getTeamXServer().StrToMain("code 0");
                    }
                }else
                    Main.getTeamXServer().StrToMain("code 302");
            }else if(Main.getTeamXServer().getServerName().equals(args[1])&&(client.permissions.contains("TeamX.cmd.console")||client.isSubServer())){
                String cmd = args[2].replace("_", " ");
                Main.getInstance().getServer().dispatchCommand(Main.getCmd(), cmd);
            }else if(client.isSubServer()||client.permissions.contains("TeamX.cmd.console")){
                for(Client c:Main.getTeamXServer().subServer){
                    c.sendStrMessage(strMessage);
                }
            }
        }
    }
}
