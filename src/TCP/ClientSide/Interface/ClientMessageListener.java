package TCP.ClientSide.Interface;

/**
 * Created by cccp on 21/11/2014.
 */
public interface ClientMessageListener {
    public static final int MESSAGE_TYPE_SERVER = 0;
    public static final int MESSAGE_TYPE_HANDLER = 1;
    public abstract void onMessageReceived(String message, int messageType);
}
