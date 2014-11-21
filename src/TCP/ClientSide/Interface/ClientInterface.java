package TCP.ClientSide.Interface;

/**
 * Created by cccp on 21/11/2014.
 */
public interface ClientInterface extends ClientMessageListener {

    public abstract void connect(String host, int port);

    public abstract void sendMessage(String message);

    public abstract void onMessageServerReceived(String message);

    public abstract void onMessageHandlerReceived(String message);

    public abstract void onConnected();

    public abstract void onDisconnected();

}
