package UDP.ClientSide.ClientClasses;

import UDP.ClientSide.Interfaces.UdpMessageListener;
import UDP.Helpers.DatagramHelper;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class MessageReceiver extends Thread {
    public static final String MESSAGE_DISCONNECTED = "#DISCONNECTED";
    private byte[] recivedData = new byte[BaseUdpClient.DATAGRAM_MESSAGE_SIZE];
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
                DatagramPacket receivedPacket = DatagramHelper.getPacket(recivedData);
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
