package client;

public class Main {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        Client client = new Client(SERVER_ADDRESS, SERVER_PORT);
        client.run();
    }
}
