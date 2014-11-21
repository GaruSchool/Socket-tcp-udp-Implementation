package UDP.Helpers;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class DatagramHelper {

    public static DatagramPacket getPacket(byte[] bytes) {
        return new DatagramPacket(bytes, bytes.length);
    }

    public static DatagramPacket getPacket(byte[] bytes, InetAddress ip, int port) {
        return new DatagramPacket(bytes, bytes.length, ip, port);
    }


}
