package com.TeamX.JavaBeast;

import com.TeamX.JavaBeast.Minecraft.*;
import com.TeamX.JavaBeast.Network.Data;
import com.TeamX.JavaBeast.Network.MessageHandlers.*;
import com.TeamX.JavaBeast.Network.MyEventHandler;
import com.TeamX.JavaBeast.Server.Client;
import com.TeamX.JavaBeast.Server.MessageHandlers.CodeMessage;
import com.TeamX.JavaBeast.Server.MessageHandlers.StopMessage;
import com.TeamX.JavaBeast.Server.MessageHandlers.SubServerMessage;
import com.TeamX.JavaBeast.Server.Server;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    private static Server server;
    private static Main instance;
    private static ConsoleCommandSender cmd;
    private int port;
    private int receiveBufferSize;
    private long throttle;
    private boolean acceptSubServers;
    private boolean onlyAcceptOnlineUsers;
    private boolean hasToVerify;
    private boolean createLog;
    private boolean startExternal;
    private boolean isSubServer;
    private String mainServer;
    private String serverName;
    private Data data;

    public static ConsoleCommandSender getCmd() {
        return cmd;
    }

    public static Main getInstance() {
        return instance;
    }

    /**
     * @return null if the TeamX server should start external
     */
    public static Server getTeamXServer() {
        return server;
    }

    @Override
    public void onEnable() {
        Main.instance = this;
        Main.cmd = Bukkit.getConsoleSender();

        checkConfig();
        loadServerOptions();

        if (!startExternal) {
            this.server = new Server(
                    this.port,
                    this.acceptSubServers,
                    this.onlyAcceptOnlineUsers,
                    this.hasToVerify,
                    this.createLog,
                    this.throttle,
                    this.receiveBufferSize,
                    this.isSubServer,
                    this.mainServer,
                    this.serverName
            );

            if(!isSubServer) {
                server.registerMessageHandler(new SubServerMessage());
                server.registerMessageHandler(new getPlayerAmountMessage());
                server.registerMessageHandler(new SetPlayerAmountMessage());
                server.registerMessageHandler(new getPlayersMessage());
                server.registerMessageHandler(new SetPlayersMessage());
                server.registerMessageHandler(new addPlayerMessage());
                server.registerMessageHandler(new removePlayerMessage());
                server.registerMessageHandler(new LoginMessage());
                server.registerMessageHandler(new VerifiedMessage());
                server.registerMessageHandler(new getServersMessage());
                server.registerMessageHandler(new setMaximumPlayers());
                server.registerMessageHandler(new getMainServer());
                server.registerMessageHandler(new getReceiveBufferSize());
                server.registerMessageHandler(new getIsSubServer());
                server.registerMessageHandler(new getAddress());
                server.registerMessageHandler(new setPort());
                server.registerMessageHandler(new getRegistered());
                server.registerMessageHandler(new getTodayRegistered());
                server.registerMessageHandler(new getTodayJoined());
                server.registerMessageHandler(new consoleInfoMessage());

                data = new Data(server);
            }else{
                server.registerMessageHandler(new CodeMessage());
                server.registerMessageHandler(new getSubPlayerAmountMessage());
                server.registerMessageHandler(new getSubPlayersMessage());
                server.registerMessageHandler(new VerifyMessage());
            }
            server.registerMessageHandler(new StopMessage());
            server.registerMessageHandler(new ReloadNetworkMessage());
            server.registerMessageHandler(new consoleCmdMessage());
            server.registerMessageHandler(new stopNetworkMessage());
            server.registerMessageHandler(new getMaximumPlayers());
        }


        Bukkit.getPluginManager().registerEvents(new MyEventHandler(), this);
        getCommand("teamx").setExecutor(new TeamXCommand());
        getCommand("account").setExecutor(new AccountCommand());
        getCommand("addPerm").setExecutor(new AddPermCommand());
        getCommand("removePerm").setExecutor(new RemovePermCommand());
        getCommand("reloadnetwork").setExecutor(new ReloadNetworkCommand());
    }

    @Override
    public void onDisable() {


        if(data != null) {
            FileConfiguration config = data.registered;
            config.set("registeredToday", new ArrayList<>());
            config.set("joinedToday", new ArrayList<>());

            for (Client client : server.subServer) {
                config.set("registeredToday_." + client.getName(), new ArrayList<>());
                config.set("joinedToday_." + client.getName(), new ArrayList<>());
            }

            try {
                config.save(new File(Main.getInstance().getDataFolder() + "/registered.yml"));
            } catch (IOException exception) {
            }
        }


        Main.server.stop();
    }

    public Data getData(){
        return data;
    }

    public void checkConfig() {
        FileConfiguration config = getConfig();

        if (!config.contains("port")) {
            config.set("port", 1997);
        }

        if (!config.contains("acceptSubServers")) {
            config.set("acceptSubServers", true);
        }

        if (!config.contains("onlyAcceptOnlineUsers")) {
            config.set("onlyAcceptOnlineUsers", false);
        }

        if (!config.contains("hasToVerify")) {
            config.set("hasToVerify", false);
        }

        if (!config.contains("createLog")) {
            config.set("createLog", true);
        }

        if (!config.contains("startExternal")) {
            config.set("startExternal", false);
        }

        if (!config.contains("throttle")) {
            config.set("throttle", 1000);
        }

        if (!config.contains("receiveBufferSize")) {
            config.set("receiveBufferSize", 1024);
        }

        if(!config.contains("isSubServer")){
            config.set("isSubServer", false);
        }

        if(!config.contains("mainServer")){
            config.set("mainServer", "127.0.0.1");
        }

        if(!config.contains("serverName")){
            config.set("serverName", "noname");
        }

        saveConfig();
    }

    public void loadServerOptions() {
        FileConfiguration config = getConfig();

        port = config.getInt("port");
        acceptSubServers = config.getBoolean("acceptSubServers");
        onlyAcceptOnlineUsers = config.getBoolean("onlyAcceptOnlineUsers");
        hasToVerify = config.getBoolean("hasToVerify");
        createLog = config.getBoolean("createLog");
        startExternal = config.getBoolean("startExternal");
        throttle = config.getLong("throttle");
        receiveBufferSize = config.getInt("receiveBufferSize");
        isSubServer = config.getBoolean("isSubServer");
        mainServer = config.getString("mainServer");
        serverName = config.getString("serverName");
    }
}
