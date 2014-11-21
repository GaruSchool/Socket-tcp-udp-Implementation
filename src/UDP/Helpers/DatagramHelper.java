package UDP.Helpers;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Created by cccp on 21/11/2014.
 */
public class DatagramHelper {

    public static DatagramPacket getPacket(byte[] bytes) {
        return new DatagramPacket(bytes, bytes.length);
    }

    public static DatagramPacket getPacket(byte[] bytes, InetAddress ip, int port) {
        return new DatagramPacket(bytes, bytes.length, ip, port);
    }


}
