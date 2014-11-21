package UDP.ClientSide.ClientImplementations;

import UDP.ClientSide.ClientClasses.BaseUdpClient;

import java.net.InetAddress;

/**
 * Created by cccp on 21/11/2014.
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
