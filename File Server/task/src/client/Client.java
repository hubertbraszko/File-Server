package client;

import client.request.Request;
import client.response.Response;
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
        Request request = userInterface.promptUserForAction();
        Response response = makeExchange(request);
        //System.out.println("RESPONSE: \n" + response.toString());
        System.out.println(userInterface.parseResponseForUser(response));
    }

    private Response makeExchange(Request request) {
        String receivedMsg = "";
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            output.writeUTF(request.toString()); // sending message to the server
            receivedMsg = input.readUTF(); // response message

        } catch (IOException e) {
            System.out.println("Could not connect to the server");
        }
        return Response.parseResponse(receivedMsg);
    }
}
