package UDP.ClientSide.ClientImplementations;

import UDP.ClientSide.ClientClasses.BaseUdpClient;

import java.net.InetAddress;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class SimpleUdpClient extends BaseUdpClient {
    public SimpleUdpClient(String ipAddress, int port) {
        super(ipAddress, port);
    }

    @Override
    public void onClientMessageReceived(String message, InetAddress ip, int port) {
        System.out.println("Server: " + message);
    }
}
