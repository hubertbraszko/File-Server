package server;

import server.storage.Storage;


public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        final int PORT = 34522;
        Server server = new Server(PORT, storage);
        System.out.println("Server started!");
        while (true) {
            server.runSocketServer();
        }
    }
}