package server;

import client.request.Request;
import client.response.Response;
import server.storage.Storage;
import server.storage.StorageCommandInvoker;
import server.storage.commands.*;
import server.storage.commands.CommandResult.CommandResult;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {

    private final int port;
    private final Storage storage;
    private final StorageCommandInvoker storageCommandInvoker;
    private final Map<String, Command> commandMap;

    public Server(int port, Storage storage) {
        this.port = port;
        this.storage = storage;
        this.storageCommandInvoker = new StorageCommandInvoker();
        this.commandMap = Map.of(
                "add", new AddCommand(this.storage),
                "get", new GetCommand(this.storage),
                "delete", new DeleteCommand(this.storage),
                "exit", new ExitCommand(this.storage)
        );
    }

    public void runSocketServer(){
        try (ServerSocket server = new ServerSocket(port)) {
            try (
                    Socket socket = server.accept();
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                String requestString = input.readUTF();
                Response response = handleRequest(requestString);
                output.writeUTF(response.toString());
            }
        } catch (IOException e) {
            System.out.println("Internal server error");
        }
    }

    private Response handleRequest(String requestString) {
        Request request = Request.parseRequest(requestString);
        Command requestedCommand = commandMap.get(request.getAction());
        requestedCommand.setContext(request);
        storageCommandInvoker.setCommand(requestedCommand);
        CommandResult commandResult = storageCommandInvoker.executeCommand();

        return commandResult.toResponse();
    }
}
