package TCP.ServerSide.Interfaces;

import TCP.ServerSide.ServerClasses.ClientHandler;

import java.net.Socket;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface TcpServerInterface extends ClientListener {

    public abstract void startListening(int port);

    public abstract void stopListening();

    public abstract void broadcastMessage(String message);

    public abstract void onHandlerMessageReceived(ClientHandler handler, String message);

    public abstract void createHandler(Socket socket);

    public abstract void removeHandler(ClientHandler handler);

    public void onClientConnected(ClientHandler handler);

    public void onClientDisconnected(ClientHandler handler);

    public void onClientMessageReceived(ClientHandler client, String message);

    public void onMessageSent(ClientHandler client, String message);

    public void onListeningStarted(int port);

    public void onListeningStopped(int port);

}
