package TCP.ServerSide.Interfaces;

import TCP.ServerSide.ServerClasses.ClientHandler;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface ClientListener {
    public static int MESSAGE_CLIENT = 0;
    public static int MESSAGE_HANDLER = 1;

    public abstract void onMessageReceived(ClientHandler client, String message, int messageType);
}
