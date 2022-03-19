package server;

import server.storage.Storage;
import server.storage.StorageCommandInvoker;
import server.storage.commands.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage(new ArrayList<>());
        Scanner scanner = new Scanner(System.in);
        StorageCommandInvoker invoker = new StorageCommandInvoker();
        final int PORT = 34522;
        Server server = new Server(PORT);

        while (true) {
            server.runSocketServer();

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
}