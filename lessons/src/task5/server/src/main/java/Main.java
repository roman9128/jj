import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1400);
            Server server = new Server(serverSocket);
            server.runServer();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
