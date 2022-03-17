package server;

import server.storage.Storage;
import server.storage.StorageCommandInvoker;
import server.storage.commands.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage(new ArrayList<>());
        Scanner scanner = new Scanner(System.in);
        StorageCommandInvoker invoker = new StorageCommandInvoker();

        while (true) {
            runSocketServer();

            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String fileName = input.length == 2 ? input[1]: "";
            switch (command.toLowerCase()) {
                case "add":
                    invoker.setCommand(new AddCommand(storage, new File(fileName)));
                    break;
                case "delete":
                    invoker.setCommand(new DeleteCommand(storage, fileName));
                    break;
                case "get":
                    invoker.setCommand(new GetCommand(storage, fileName));
                    break;
                case "exit":
                    System.exit(0);
            }
            invoker.executeCommand();
        }
    }

    public static void runSocketServer(){
        int PORT = 34522;
        System.out.println("Server started!");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accepting a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF(); // reading a message
                    System.out.println("Received: " + msg);


                    output.writeUTF("All files were sent!"); // resend it to the client
                    System.out.println("Sent: All files were sent!");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}