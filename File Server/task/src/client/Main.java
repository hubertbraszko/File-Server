package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");

            String msg = "Give me everything you have!";

            System.out.println("Sent: " + msg);

            output.writeUTF(msg); // sending message to the server
            String receivedMsg = input.readUTF(); // response message

            System.out.println("Received: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
