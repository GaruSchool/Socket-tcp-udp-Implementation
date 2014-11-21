package TCP.ClientSide.Implementations;

import TCP.ClientSide.ClientClasses.BaseTcpClient;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class SimpleTcpClient extends BaseTcpClient {

    @Override
    public void onMessageServerReceived(String message) {
        System.out.println("ServerSide: " + message);
    }

    @Override
    public void onConnected() {
        System.out.println("Connesso al server!");
    }
}
