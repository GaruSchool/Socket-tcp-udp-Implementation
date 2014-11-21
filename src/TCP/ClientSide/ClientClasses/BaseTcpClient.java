package TCP.ClientSide.ClientClasses;

import TCP.ClientSide.Interface.ClientInterface;
import TCP.ClientSide.Interface.ClientMessageListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class BaseTcpClient implements ClientInterface {

    private Socket socket = null;
    private ClientReceiver receiver = null;
    private boolean isConnected;

    @Override
    public void connect(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            this.receiver = new ClientReceiver(this, socket);
            this.receiver.start();
            this.isConnected = true;
            this.onConnected();
        } catch (IOException e) {
            System.out.println("Impossibile aprire una connessione verso " + host);
            isConnected = false;
        }
    }

    @Override
    public void sendMessage(String message) {
        if (socket != null)
            try {
                new PrintWriter(socket.getOutputStream(), true).println(message);
            } catch (IOException e) {
                if (receiver != null)
                    receiver.interrupt();
                receiver = null;
                isConnected = false;
            }
    }


    @Override
    public void onMessageHandlerReceived(String message) {
        if (message.equals(ClientReceiver.MESSAGE_DISCONNECTED)) {
            this.receiver.dispose();
            isConnected = false;
        }
    }

    @Override
    public void onMessageReceived(String message, int messageType) {
        if (messageType == ClientMessageListener.MESSAGE_TYPE_SERVER)
            onMessageServerReceived(message);
        else if (messageType == ClientMessageListener.MESSAGE_TYPE_HANDLER)
            onMessageHandlerReceived(message);
    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onMessageServerReceived(String message) {

    }


}
