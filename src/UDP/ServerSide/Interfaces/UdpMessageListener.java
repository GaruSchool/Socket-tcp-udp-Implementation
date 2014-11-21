package UDP.ServerSide.Interfaces;

import java.net.InetAddress;

/**
 * Created by cccp on 21/11/2014.
 */
public interface UdpMessageListener {
    public abstract void onMessageReceived(String message,InetAddress ip,int port);
}
