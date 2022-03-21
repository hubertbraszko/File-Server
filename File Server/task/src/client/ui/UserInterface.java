package client.ui;

import client.request.Request;
import client.ui.actions.*;

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
}
