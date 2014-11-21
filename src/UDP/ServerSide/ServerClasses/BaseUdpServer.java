package UDP.ServerSide.ServerClasses;

import UDP.ServerSide.Interfaces.UdpServerInterface;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by cccp on 21/11/2014.
 */
public class BaseUdpServer implements UdpServerInterface {

    public static final int DATAGRAM_MESSAGE_SIZE = 1024;

    protected DatagramSocket socket;
    private MessageReceiver receiver;

    @Override
    public void startListening(int port) {
        try {
            this.socket = new DatagramSocket(port);
            receiver = new MessageReceiver(this, socket);
            receiver.start();
            onListeningStarted(port);
        } catch (SocketException e) {
            System.out.println("Impossibile avviare server sulla porta " + port);
        }

    }

    @Override
    public void stopListening() {
        if (this.socket != null)
            this.socket.close();
        this.socket = null;

        if (this.receiver != null)
            this.receiver.interrupt();
        onListeningStopped();
    }

    @Override
    public void onMessageReceived(String message, InetAddress ip, int port) {
            onClientMessageReceived(message, ip, port);
    }

    @Override
    public void onListeningStarted(int port) {

    }

    @Override
    public void onListeningStopped() {

    }

    @Override
    public void onClientMessageReceived(String message, InetAddress ip, int port) {

    }


}
