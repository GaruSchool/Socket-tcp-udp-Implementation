package TCP.ClientSide.ClientClasses;

import TCP.ClientSide.Interface.ClientMessageListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */


public class ClientReceiver extends Thread {

    public static String MESSAGE_DISCONNECTED = "#DISCONNECTED";

    private ClientMessageListener listener;
    private Socket socket;

    public ClientReceiver(ClientMessageListener listener, Socket socket) {
        this.listener = listener;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!this.isInterrupted()) {
                listener.onMessageReceived(input.readLine(), ClientMessageListener.MESSAGE_TYPE_SERVER);
            }

        } catch (IOException e) {
            notifyDisconnected();
        }
    }

    private void notifyDisconnected() {
        listener.onMessageReceived(MESSAGE_DISCONNECTED, ClientMessageListener.MESSAGE_TYPE_HANDLER);
    }

    public void dispose() {
        this.interrupt();
        try {
            this.socket.close();
        } catch (IOException e) {

        }
        this.socket = null;
    }
}
