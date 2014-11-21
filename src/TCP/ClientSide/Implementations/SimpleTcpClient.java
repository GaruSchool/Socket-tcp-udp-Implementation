package TCP.ClientSide.Implementations;


import TCP.ClientSide.ClientClasses.BaseTcpClient;

public class SimpleTcpClient extends BaseTcpClient {

    @Override
    public void onMessageServerReceived(String message) {
        System.out.println("Server: " + message);
    }

    @Override
    public void onConnected() {
        System.out.println("Connesso al server!");
    }
}
