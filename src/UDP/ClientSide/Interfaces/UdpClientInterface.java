package UDP.ClientSide.Interfaces;

import java.net.InetAddress;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface UdpClientInterface extends UdpMessageListener {
    public abstract void onClientMessageReceived(String message, InetAddress ip, int port);

    public abstract void onClientDisconnected();

    public abstract void disconnect();
}
