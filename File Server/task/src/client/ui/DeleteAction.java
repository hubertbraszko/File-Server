package client.ui;

import client.request.Request;

import java.util.Scanner;

public class DeleteAction extends Action {
    public DeleteAction() {
        super(3, "delete a file");
    }

    @Override
    public Request makeRequest(Scanner scanner) {
        System.out.println("Enter filename: ");
        String fileName = scanner.nextLine();

        return new Request("delete", fileName);
    }
}
