package UDP.ServerSide.Interfaces;

import java.net.InetAddress;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface UdpMessageListener {
    public abstract void onMessageReceived(String message, InetAddress ip, int port);
}
