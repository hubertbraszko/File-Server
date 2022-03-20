package client;

import client.request.Request;
import client.ui.UserInterface;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private final String serverAddress;
    private final int serverPort;
    private final UserInterface userInterface;


    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.userInterface = new UserInterface();
    }

    public void run() {
        userInterface.promptUserForAction();
    }

    private String makeExchange(Request request) {
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");

            String msg = "Give me everything you have!";

            System.out.println("Sent: " + msg);

            output.writeUTF(msg); // sending message to the server
            String receivedMsg = input.readUTF(); // response message


        } catch (IOException e) {
            e.printStackTrace();
        }
        return ""; //TODO
    }
}
