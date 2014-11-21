package TCP.ClientSide.Interface;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public interface ClientMessageListener {
    public static final int MESSAGE_TYPE_SERVER = 0;
    public static final int MESSAGE_TYPE_HANDLER = 1;

    public abstract void onMessageReceived(String message, int messageType);
}
