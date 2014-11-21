package UDP.Tests;

import UDP.ClientSide.ClientClasses.BaseUdpClient;
import UDP.ClientSide.ClientImplementations.SimpleUdpClient;
import UDP.Helpers.ConsoleHelper;

/**
 * Created by cccp on 21/11/2014.
 */
public class UdpClientTest {

    public static void main(String[] args) {

        BaseUdpClient client = new SimpleUdpClient("127.0.0.1", 9999);

        client.sendMessage("Ciao mi sono connesso");

        while(client.isConnected())
            client.sendMessage(ConsoleHelper.getInput());

    }
}
