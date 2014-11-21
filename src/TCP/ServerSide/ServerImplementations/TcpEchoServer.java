package TCP.ServerSide.ServerImplementations;

import TCP.ServerSide.ServerClasses.BaseTcpServer;
import TCP.ServerSide.ServerClasses.ClientHandler;

/**
 * Created by cccp on 21/11/2014.
 */
public class TcpEchoServer extends BaseTcpServer {

    @Override
    public void onClientMessageReceived(ClientHandler client, String message) {
        client.sendMessage(message);
        System.out.println(client.getClientName() + ": " + message);
    }

    @Override
    public void onClientConnected(ClientHandler handler) {
        System.out.println("Client Connesso: " + handler.getClientName());
    }

    @Override
    public void onClientDisconnected(ClientHandler handler) {
        System.out.println("Client Disconnesso: " + handler.getClientName());
    }

    @Override
    public void onListeningStarted(int port) {
        System.out.println("Server listening on port: " + port);
    }
}
