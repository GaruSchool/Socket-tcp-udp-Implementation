package TCP.Tests;

import TCP.ClientSide.ClientClasses.BaseTcpClient;
import TCP.ClientSide.Implementations.SimpleTcpClient;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class TcpClientTest {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                BaseTcpClient client = new SimpleTcpClient();
                client.connect("127.0.0.1", 9999);
                client.sendMessage("Connesso!");
            }
        }.start();
    }
}
