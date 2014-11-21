package UDP.ServerSide.ServerClasses;

import UDP.ServerSide.Interfaces.UdpMessageListener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by cccp on 21/11/2014.
 */
public class MessageReceiver extends Thread {
    private byte[] recivedData = new byte[BaseUdpServer.DATAGRAM_MESSAGE_SIZE];
    public static final String MESSAGE_DISCONNECTED = "#DISCONNECTED";

    private UdpMessageListener listener;
    private DatagramSocket socket;

    public MessageReceiver(UdpMessageListener listener, DatagramSocket socket) {
        this.listener = listener;
        this.socket = socket;
    }


    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                DatagramPacket receivedPacket = new DatagramPacket(new byte[1024], new byte[1024].length);// DatagramHelper.getPacket(recivedData);
                socket.receive(receivedPacket);
                if (receivedPacket != null)
                    listener.onMessageReceived(new String(receivedPacket.getData()),
                            receivedPacket.getAddress(),
                            receivedPacket.getPort());
            } catch (IOException e) {
                notifyDisconnected();
            }

        }
    }

    private void notifyDisconnected() {
        listener.onMessageReceived(MESSAGE_DISCONNECTED, null, 0);
    }

    public void dispose() {
        this.interrupt();
    }
}
