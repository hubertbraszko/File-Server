package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void runSocketServer(){
        System.out.println("Server started!");
        try (ServerSocket server = new ServerSocket(port)) {
            try (
                    Socket socket = server.accept(); // accepting a new client
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                String msg = input.readUTF(); // reading a message
                System.out.println("Received: " + msg);


                output.writeUTF("All files were sent!"); // resend it to the client
                System.out.println("Sent: All files were sent!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
