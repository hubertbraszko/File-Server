package client.ui;

import client.request.Request;
import client.response.Response;
import client.ui.actions.*;
import server.storage.commands.Codes;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final List<Action> actions;
    private final String menu;
    private final Scanner inputScanner;

    public UserInterface() {
        this.actions = List.of(
                new GetAction(),
                new AddAction(),
                new DeleteAction(),
                new ExitAction());
        this.menu = composeMenu();
        inputScanner = new Scanner(System.in);
    }

    public Request promptUserForAction() throws IllegalArgumentException{
        printMenu();
        String input = inputScanner.nextLine();
        int actionId = "exit".equals(input) ? 0 : Integer.parseInt(input);
        Action requestedAction = actions.stream()
                .filter(action -> action.getId() == actionId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return requestedAction.makeRequest(inputScanner);
    }

    private void printMenu() {
        System.out.println(menu);
    }

    private String composeMenu(){
        StringBuilder actionsDescription = new StringBuilder("Enter action (");
        for(Action action : actions) {
            if(action.isVisibleInUI()) {
                actionsDescription.append(String.format("%d - %s, ", action.getId(), action.getDescription()));
            }
        }
        actionsDescription.delete(actionsDescription.length() - 2, actionsDescription.length());
        actionsDescription.append("): ");

        return actionsDescription.toString();
    }

    //FIXME - make this code better
    public String parseResponseForUser(Response response){
        if(response.getCode() == Codes.OK) {
            if(response.getMessage().contains("added")) {
                return "The response says that the file was created!";
            } else if (response.getMessage().contains("sent")) {
                return "The content of the file is: " + response.getFileContent();
            }
            return "The response says that the file was successfully deleted!";
        } else if (response.getCode() == Codes.NOT_FOUND) {
            return "The response says that the file was not found!";
        } else {
            return "The response says that creating the file was forbidden!";
        }
    }
}
