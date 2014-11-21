package TCP.ClientSide.Interface;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface ClientInterface extends ClientMessageListener {

    public abstract void connect(String host, int port);

    public abstract void sendMessage(String message);

    public abstract void onMessageServerReceived(String message);

    public abstract void onMessageHandlerReceived(String message);

    public abstract void onConnected();

    public abstract void onDisconnected();

}
