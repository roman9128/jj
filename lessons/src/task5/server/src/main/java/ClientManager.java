import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager implements Runnable {

    private final Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String name;
    public final static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket) {
        this.socket = socket;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = bufferedReader.readLine();
            clients.add(this);
            System.out.println(name + " connected");
            broadcastMsg("Server: " + name + " connected");
        } catch (IOException e) {
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String msgFromClient;
        while (socket.isConnected()) {
            try {
                msgFromClient = bufferedReader.readLine();
                broadcastMsg(msgFromClient);
            } catch (IOException e) {
                closeAll(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    private void broadcastMsg(String msg) {
        try {
            if (msg.split(" ")[1].startsWith("@")) { // выявление получателя сообщения по наличию спецсимвола "@"
                String recipient = getRecipient(msg);
                if (recipient.isEmpty()) {
                    this.bufferedWriter.write("no user with this name");
                    this.bufferedWriter.newLine();
                    this.bufferedWriter.flush();
                } else {
                    for (ClientManager client : clients) {
                        if (client.getName().equals(recipient)) {
                            client.bufferedWriter.write(msg);
                            client.bufferedWriter.newLine();
                            client.bufferedWriter.flush();
                        }
                    }
                }
            } else {
                for (ClientManager client : clients) {
                    if (!client.getName().equals(name)) {
                        client.bufferedWriter.write(msg);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                }
            }
        } catch (IOException e) {
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    private String getRecipient(String msg) {
        try {
            String recipient = msg.split(" ")[1].replaceFirst("@", "");
            for (ClientManager client : clients) {
                if (client.getName().equals(recipient)) {
                    return recipient;
                }
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    private String getName() {
        return name;
    }

    private void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClient();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeClient() {
        clients.remove(this);
        System.out.println(name + " quit");
        broadcastMsg("Server: " + name + " quit");
    }
}
