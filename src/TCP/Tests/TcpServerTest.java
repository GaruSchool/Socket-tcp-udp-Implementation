package TCP.Tests;

import TCP.ServerSide.ServerClasses.BaseTcpServer;
import TCP.ServerSide.ServerImplementations.TcpEchoServer;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class TcpServerTest {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                BaseTcpServer server = new TcpEchoServer();
                server.startListening(9999);
            }
        }.start();
    }
}
