package TCP.ServerSide.ServerClasses;


import TCP.ServerSide.Interfaces.ClientListener;
import TCP.ServerSide.Interfaces.TcpServerInterface;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class BaseTcpServer implements TcpServerInterface {

    private ArrayList<ClientHandler> clientHandlers;
    private ServerSocket socket = null;
    private boolean isRunning;
    private int currentPort;

    public BaseTcpServer() {
        this.clientHandlers = new ArrayList<ClientHandler>();
        isRunning = false;
    }

    @Override
    public void startListening(int port) {
        try {
            this.socket = new ServerSocket(port);
            this.onListeningStarted(port);
            this.isRunning = true;
            this.currentPort = port;
            while (isRunning)
                createHandler(socket.accept());

        } catch (IOException e) {
            isRunning = false;
            System.out.println("Impossibile avviare il server - Errore durante l'apertura della connessione");
        }
    }

    @Override
    public void stopListening() {
        try {
            this.isRunning = false;
            this.broadcastMessage(ClientHandler.MESSAGE_HANDLER_DISCONNECTED);
            if (socket != null)
                this.socket.close();
            this.onListeningStopped(currentPort);
        } catch (IOException e) {
        }
    }

    @Override
    public void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clientHandlers)
            clientHandler.sendMessage(message);
    }


    @Override
    public void onHandlerMessageReceived(ClientHandler handler, String message) {
        if (message.equals(ClientHandler.MESSAGE_HANDLER_DISCONNECTED))
            removeHandler(handler);
    }

    @Override
    public void onMessageReceived(ClientHandler client, String message, int messageType) {
        synchronized (this) {
            if (messageType == ClientListener.MESSAGE_CLIENT)
                onClientMessageReceived(client, message);
            else if (messageType == ClientListener.MESSAGE_HANDLER)
                onHandlerMessageReceived(client, message);
        }
    }


    @Override
    public void createHandler(Socket socket) {
        ClientHandler newHandler = new ClientHandler(socket, this);
        this.clientHandlers.add(newHandler);
        newHandler.start();
        this.onClientConnected(newHandler);
    }

    @Override
    public void removeHandler(ClientHandler handler) {
        handler.dispose();
        this.clientHandlers.remove(handler);
        this.onClientDisconnected(handler);
    }

    @Override
    public void onClientConnected(ClientHandler handler) {

    }

    @Override
    public void onClientDisconnected(ClientHandler handler) {

    }

    @Override
    public void onClientMessageReceived(ClientHandler client, String message) {

    }

    @Override
    public void onMessageSent(ClientHandler client, String message) {

    }

    @Override
    public void onListeningStarted(int port) {

    }

    @Override
    public void onListeningStopped(int port) {

    }

}
