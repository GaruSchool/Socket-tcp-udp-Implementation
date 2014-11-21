package UDP.ClientSide.Interfaces;

import java.net.InetAddress;

/**
 * Created by cccp on 21/11/2014.
 */
public interface UdpClientInterface extends UdpMessageListener {
    public abstract void onClientMessageReceived(String message, InetAddress ip, int port);
}
