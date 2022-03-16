package server;

import server.storage.Storage;
import server.storage.StorageCommandInvoker;
import server.storage.commands.AddCommand;
import server.storage.commands.DeleteCommand;
import server.storage.commands.GetCommand;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage(new ArrayList<>());
        Scanner scanner = new Scanner(System.in);
        StorageCommandInvoker invoker = new StorageCommandInvoker();

        while (true) {
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