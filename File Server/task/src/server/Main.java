package server;

import server.storage.Storage;
import server.storage.StorageCommandInvoker;
import server.storage.commands.*;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        StorageCommandInvoker invoker = new StorageCommandInvoker();
        final int PORT = 34522;
        Server server = new Server(PORT, storage);

        while (true) {
            server.runSocketServer();
        }
    }
}