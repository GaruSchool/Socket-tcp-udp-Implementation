package UDP.ClientSide.ClientClasses;

import UDP.ClientSide.Interfaces.UdpClientInterface;
import UDP.Helpers.DatagramHelper;

import java.io.IOException;
import java.net.*;

/**
 * Created by cccp on 21/11/2014.
 */
public class BaseUdpClient implements UdpClientInterface {

    public static final int DATAGRAM_MESSAGE_SIZE = 1024;

    private DatagramSocket socket;
    private InetAddress IPAddress;
    private int port;

    private MessageReceiver receiver;

    public BaseUdpClient(String ipAddress, int port) {
        try {
            IPAddress = InetAddress.getByName(ipAddress);
            this.port = port;
            this.socket = new DatagramSocket();
        } catch (UnknownHostException e) {
            System.out.println("Impossibile risolvere: " + ipAddress);
        } catch (SocketException e) {
            System.out.println("Impossibile instanziare la socket");
        }

        this.receiver = new MessageReceiver(this, socket);
        receiver.start();
    }

    public void sendMessage(String message) {
        if (receiver == null)
            this.receiver = new MessageReceiver(this, socket);

        try {
            DatagramPacket packet = DatagramHelper.getPacket(message.getBytes(), IPAddress, port);
            socket.send(packet);

        } catch (IOException e) {
            System.out.println("Impossibile inviare messaggio @: " + IPAddress.toString());
            receiver.interrupt();
            receiver = null;
            socket.close();
        }
    }

    @Override
    public void onMessageReceived(String message, InetAddress ip, int port) {
        if (message.equals(MessageReceiver.MESSAGE_DISCONNECTED)) {
            receiver.interrupt();
            socket.close();
        } else
            onClientMessageReceived(message, ip, port);
    }

    @Override
    public void onClientMessageReceived(String message, InetAddress ip, int port) {
    }

    public boolean isConnected() {
        return this.socket.isConnected();
    }
}
