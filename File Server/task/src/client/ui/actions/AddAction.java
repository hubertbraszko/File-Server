package client.ui.actions;

import client.request.Request;

import java.util.Scanner;

public class AddAction extends Action {

    public AddAction() {
        super(2, "create a file");
    }

    @Override
    public Request makeRequest(Scanner scanner) {
        System.out.println("Enter filename: ");
        String fileName = scanner.nextLine();
        System.out.println("Enter file content: ");
        String fileContent = scanner.nextLine();

        return new Request("add", fileName, fileContent);
    }
}
