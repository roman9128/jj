package rt;

import java.io.IOException;
// import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("your name: ");
            String name = scanner.nextLine();

            Socket socket = new Socket("localhost", 1400);
            Client client = new Client(socket, name);

//            InetAddress inetAddress = socket.getInetAddress();
//            String remoteIP = inetAddress.getHostAddress();
//            System.out.println(inetAddress + " inetadress");
//            System.out.println(remoteIP + " remote IP");
//            System.out.println(socket.getLocalPort() + " local port");

            client.listenForMsg();
            client.sendMsg();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
