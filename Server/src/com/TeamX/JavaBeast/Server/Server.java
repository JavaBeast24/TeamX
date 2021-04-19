package com.TeamX.JavaBeast.Server;

import com.TeamX.JavaBeast.Events.ClientConnectEvent;
import com.TeamX.JavaBeast.Events.MessageReceiveEvent;
import com.TeamX.JavaBeast.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {

    private final int port;
    private final int receiveBufferSize;

    private final long throttle;

    private final boolean acceptSubServers;
    private final boolean hasToVerify;
    private final boolean onlyAcceptOnlineUsers;
    private final List<Thread> running_Threads = new ArrayList<>();
    private boolean createLog;
    private boolean running = true;
    private boolean isSubServer;
    private String mainServer;
    private String serverName;
    public ServerSocket serverSocket;
    private Socket socket;

    private final List<MessageHandler> messageHandlers = new ArrayList<>();
    public final List<Client> clients = new ArrayList<>();
    public final List<Client> subServer = new ArrayList<>();
    public final List<Client> CLIENTS = new ArrayList<>();

    /**
     * @param port                  the port were the server will run on
     * @param acceptSubServers      should be true if you have a spigot server network
     * @param onlyAcceptOnlineUsers if true the server will only accept clients when the connected minecraft user is online
     * @param hasToVerify           if true the user has to use the command /connect after starting the client to connect to the server
     * @param createLog             if true the server will log all connects / disconnects and actions on the TeamX server
     * @param throttle              the time to wait between two connections
     * @param receiveBufferSize     the maximum of bytes to receive
     */
    public Server(int port, boolean acceptSubServers, boolean onlyAcceptOnlineUsers, boolean hasToVerify, boolean createLog,
                  long throttle, int receiveBufferSize, boolean isSubServer, String mainServer, String serverName) {
        this.port = port;
        this.hasToVerify = hasToVerify;
        this.acceptSubServers = acceptSubServers;
        this.createLog = createLog;
        this.onlyAcceptOnlineUsers = onlyAcceptOnlineUsers;
        this.throttle = throttle;
        this.receiveBufferSize = receiveBufferSize;
        this.isSubServer = isSubServer;
        this.mainServer = mainServer;
        this.serverName = serverName;

        start();
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isCreateLog() {
        return createLog;
    }

    public boolean isOnlyAcceptOnlineUsers() {
        return onlyAcceptOnlineUsers;
    }

    public boolean isHasToVerify() {
        return hasToVerify;
    }

    public boolean isAcceptSubServers() {
        return acceptSubServers;
    }

    public long getThrottle() {
        return throttle;
    }

    public int getPort() {
        return port;
    }

    public int getReceiveBufferSize() {
        return receiveBufferSize;
    }

    public boolean isSubServer(){
        return isSubServer;
    }

    public String getMainServer(){
        return mainServer;
    }

    public void registerMessageHandler(MessageHandler messageHandler) {
        this.messageHandlers.add(messageHandler);
    }

    public void received(byte[] byteMessage, String strMessage, Client client) {

        String[] msg = strMessage.split(" ");

        MessageReceiveEvent receiveEvent = new MessageReceiveEvent(client, strMessage, byteMessage, msg);

        Bukkit.getPluginManager().callEvent(receiveEvent);

        byteMessage = receiveEvent.getByteMessage();
        strMessage = receiveEvent.getMessage();
        msg = receiveEvent.getArgs();

        for (MessageHandler msgHandler : messageHandlers) {
            msgHandler.onReceive(byteMessage, strMessage, msg, client);
        }
    }

    private void start() {
        Log("starting server.");

        Main.getCmd().sendMessage("[§bTeamX§7]§a port=" + port);
        Main.getCmd().sendMessage("[§bTeamX§7]§a acceptSubServers=" + acceptSubServers);
        Main.getCmd().sendMessage("[§bTeamX§7]§a onlyAcceptOnlineUsers=" + onlyAcceptOnlineUsers);
        Main.getCmd().sendMessage("[§bTeamX§7]§a hasToVerify=" + hasToVerify);
        Main.getCmd().sendMessage("[§bTeamX§7]§a createLog=" + createLog);
        Main.getCmd().sendMessage("[§bTeamX§7]§a throttle=" + throttle);
        Main.getCmd().sendMessage("[§bTeamX§7]§a receiveBufferSize=" + receiveBufferSize);
        Main.getCmd().sendMessage("[§bTeamX§7]§a isSubServer=" + isSubServer);
        Main.getCmd().sendMessage("[§bTeamX§7]§a mainServer=" + mainServer);
        Main.getCmd().sendMessage("[§bTeamX§7]§a serverName="+serverName);

        if(!isSubServer) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                this.serverSocket = serverSocket;
                ConnectionListener();
                Main.getCmd().sendMessage("[§bTeamX§7]§a Server is now online!");

            } catch (Exception exception) {
                //Main.getCmd().sendMessage("[§bTeamX§7]§4 failed to start server : " + exception.getMessage() + " -> disabling plugin.");
                //Bukkit.getPluginManager().disablePlugin(Main.getInstance());
            }
        }else{
            try{
                Socket socket = new Socket(mainServer, port);
                this.socket = socket;
                Main.getCmd().sendMessage("[§bTeamX§7]§a now connected to Main server!");
                Receive();

                StrToMain("subServer "+serverName);
                StrToMain("setPort "+Main.getInstance().getServer().getPort());
            }catch (Exception exception){
                Main.getCmd().sendMessage("[§bTeamX§7]§4 failed to connect to server : " + exception.getMessage() + " -> disabling plugin.");
                Bukkit.getPluginManager().disablePlugin(Main.getInstance());
            }
        }

    }

    private void Receive() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                DataInputStream dataInputStream = null;

                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                } catch (Exception exception) {
                    Main.getCmd().sendMessage("[§bTeamX§7] §4Error while creating inputStream : " + exception.getMessage() + " -> disconnecting.");
                    Main.getTeamXServer().Log("Error while creating inputStream : " + exception.getMessage() + " -> disconnecting.");
                    stop();
                }

                while (running) {
                    try {

                        if(!(dataInputStream.available() > 0)){
                            if(socket.isClosed()){
                                Main.getCmd().sendMessage("[§bTeamX§7] §4Error while receiving message  -> disconnecting.");
                                Main.getTeamXServer().Log("Error while receiving message  -> disconnecting.");
                                stop();
                                break;
                            }else
                                continue;
                        }

                        byte[] _bytes;

                        if(dataInputStream.available() < receiveBufferSize){
                            _bytes = new byte[dataInputStream.available()];
                        }else
                            _bytes = new byte[receiveBufferSize];


                        dataInputStream.read(_bytes);

                        String msg = new String(_bytes);

                        String[] MSG = msg.split("/");

                        for(String s:MSG) {
                            Main.getCmd().sendMessage("[§bTeamX§7]§a Received message : " + s);
                            Main.getTeamXServer().Log("Received message : " + s);

                            Main.getTeamXServer().received(s.getBytes(StandardCharsets.UTF_8), s, null);
                        }

                    } catch (Exception exception) {

                        exception.printStackTrace();

                        Main.getCmd().sendMessage("[§bTeamX§7] §4Error while receiving message : " + exception.getMessage() + " -> disconnecting.");
                        Main.getTeamXServer().Log("Error while receiving message : " + exception.getMessage() + " -> disconnecting.");
                        stop();
                        return;
                    }
                }
            }
        });

        thread.start();
        running_Threads.add(thread);
    }

    public String getServerName(){
        return serverName;
    }

    private void ConnectionListener() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Socket socket = serverSocket.accept();
                        Main.getCmd().sendMessage("[§bTeamX§7] §aNew connection. (" + socket.getInetAddress().toString() + ")");
                        Log("New connection. (" + socket.getInetAddress().toString() + ")");

                        Client client = new Client(socket, "noname", false, receiveBufferSize);

                        ClientConnectEvent connectEvent = new ClientConnectEvent(client);
                        Bukkit.getPluginManager().callEvent(connectEvent);

                        if (connectEvent.isCancelled()) {
                            client.stop();
                            continue;
                        }

                        clients.add(client);
                        CLIENTS.add(client);


                        Thread.sleep(throttle);
                    } catch (Exception exception) {
                        Main.getCmd().sendMessage("[§bTeamX§7] §4Error while accepting connection : " + exception.getMessage() + " -> stopping server.");
                        stop();
                    }
                }
            }
        });

        thread.start();
        running_Threads.add(thread);
    }

    public void Log(String _log) {
        if (createLog) {
            FileConfiguration log = getLog();
            log.set(getLogTime(), _log);
            saveLog(log);
        }
    }

    public String getLogTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("[yyyy-MM-dd-HH:mm:ss:SS]");
        return format.format(date);
    }

    public FileConfiguration getLog() {
        try {
            FileConfiguration log = YamlConfiguration.loadConfiguration(new File(Main.getInstance().getDataFolder() + "/log.yml"));
            return log;
        } catch (Exception exception) {
            Main.getCmd().sendMessage("§7[§bTeamX§7] §4error while creating log file : " + exception.getMessage() + " -> no log will be created!");
            this.createLog = false;
        }

        return null;
    }

    public void saveLog(FileConfiguration log) {
        try {
            log.save(new File(Main.getInstance().getDataFolder() + "/log.yml"));
        } catch (Exception exception) {
            Main.getCmd().sendMessage("§7[§bTeamX§7] §4error while saving log file : " + exception.getMessage() + " -> no log will be created!");
            this.createLog = false;
        }
    }

    public void StrToAllCLIENTS(String msg) {
        for (Client client : CLIENTS) {
            client.sendStrMessage(msg);
        }
    }

    public void StrToAllSubServers(String msg) {
        for (Client client : subServer) {
            client.sendStrMessage(msg);
        }
    }

    public void StrToAllClients(String msg) {
        for (Client client : clients) {
            client.sendStrMessage(msg);
        }
    }

    public void StrToMain(String msg){
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write((msg+"/").getBytes(StandardCharsets.UTF_8));
            outputStream.flush();

            Main.getCmd().sendMessage("[§bTeamX§7] §aSent msg : "+msg);

        }catch(Exception exception){
            Main.getCmd().sendMessage("[§bTeamX§7]§4 Error while sending message to parent : "+exception.getMessage()+" -> disconnecting.");
            Main.getTeamXServer().Log("Error while sending message to parent : "+exception.getMessage()+" -> disconnecting.");
        }
    }

    /**
     * should be called when the plugin gets stopped
     */
    public void stop() {

        Main.getCmd().sendMessage("[§bTeamX§7]§a stopping...");

        running = false;

        for (Thread thread : running_Threads) {
            thread.interrupt();
        }

        while(clients.size() > 0){
            clients.get(0).stop();
        }

        try {
            StrToAllClients("stop");
            serverSocket.close();
            Main.getCmd().sendMessage("[§bTeamX§7]§a Server closed!");
        } catch (Exception exception) {
        }

        try {
            StrToMain("stop");
            socket.close();
            Main.getCmd().sendMessage("[§bTeamX§7]§a Socket closed!");
        } catch (Exception exception) {
        }

        Main.getCmd().sendMessage("[§bTeamX§7]§a Server stopped.");
        Log("server stopped.");
    }
}