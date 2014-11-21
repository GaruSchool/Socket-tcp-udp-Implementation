package UDP.Tests;

import UDP.ServerSide.ServerClasses.BaseUdpServer;
import UDP.ServerSide.ServerImplementations.UdpServerImplementation;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class UdpServerTest {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                BaseUdpServer server = new UdpServerImplementation();
                server.startListening(9999);
            }
        }.start();
    }
}
