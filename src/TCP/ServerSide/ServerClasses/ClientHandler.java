package TCP.ServerSide.ServerClasses;

import TCP.ServerSide.Interfaces.ClientListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Tommaso Garuglieri on 21/11/2014.
 * GitHub Repository: https://github.com/GaruSchool/Socket-tcp-udp-Implementation/
 * Contact: garuglieritommaso@gmail.com
 */

public class ClientHandler extends Thread {

    public final static String MESSAGE_HANDLER_DISCONNECTED = "#DISCONNECTED";

    private Socket socket;
    private ClientListener listener;

    public ClientHandler(Socket socket, ClientListener listener) {
        this.socket = socket;
        this.listener = listener;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!this.isInterrupted()) {
                String message = reader.readLine();
                if (message != null)
                    this.listener.onMessageReceived(this, message, ClientListener.MESSAGE_CLIENT);
                else
                    notifyClientDisconnected();
            }

        } catch (IOException e) {
            notifyClientDisconnected();
        }
    }

    public void sendMessage(String message) {
        try {
            new PrintWriter(socket.getOutputStream(), true).println(message);
        } catch (IOException e) {
            this.notifyClientDisconnected();
        }
    }

    public void dispose() {
        if (socket != null)
            try {
                this.socket.close();
                Thread.currentThread().interrupt();
            } catch (IOException e) {
            }
    }

    private void notifyClientDisconnected() {
        listener.onMessageReceived(this, ClientHandler.MESSAGE_HANDLER_DISCONNECTED, ClientListener.MESSAGE_HANDLER);
    }

    public String getClientName() {
        return this.socket.getInetAddress().toString();
    }

}
