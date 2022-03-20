package client.ui.actions;

import client.request.Request;

import java.util.Scanner;

public class GetAction extends Action{

    public GetAction() {
        super(1, "get a file");
    }

    @Override
    public Request makeRequest(Scanner scanner) {
        System.out.println("Enter filename: ");
        String fileName = scanner.nextLine();

        return new Request("get", fileName);
    }
}
