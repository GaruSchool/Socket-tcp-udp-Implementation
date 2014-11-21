package UDP.ServerSide.ServerImplementations;

import UDP.Helpers.DatagramHelper;
import UDP.ServerSide.ServerClasses.BaseUdpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class UdpServerImplementation extends BaseUdpServer {

    @Override
    public void onClientMessageReceived(String message, InetAddress ip, int port) {
        System.out.println(message);
        String answer = message.toUpperCase();
        DatagramPacket datagramPacket = DatagramHelper.getPacket(answer.getBytes(), ip, port);
        try {
            socket.send(datagramPacket);
        } catch (IOException e) {
            System.out.println("Impossibile inviare il messaggio @ " + ip.toString() + ":" + port);
        }
    }
}
