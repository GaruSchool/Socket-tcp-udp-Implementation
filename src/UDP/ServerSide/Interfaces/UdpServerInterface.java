package UDP.ServerSide.Interfaces;

import java.net.InetAddress;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface UdpServerInterface extends UdpMessageListener {
    public abstract void startListening(int port);

    public abstract void stopListening();

    public abstract void onListeningStarted(int port);

    public abstract void onListeningStopped();

    public abstract void onClientMessageReceived(String message, InetAddress ip, int port);
}
