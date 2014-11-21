package TCP.ServerSide.Interfaces;

import TCP.ServerSide.ServerClasses.ClientHandler;

public interface ClientListener {
    public static int MESSAGE_CLIENT = 0;
    public static int MESSAGE_HANDLER = 1;

    public abstract void onMessageReceived(ClientHandler client, String message, int messageType);
}
