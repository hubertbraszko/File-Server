package client.ui;

import java.util.List;

public class UserInterface {

    private final List<Action> actions;
    private final String menu;

    public UserInterface() {
        this.actions = List.of(
                new GetAction(),
                new AddAction(),
                new DeleteAction());
        this.menu = composeMenu();

    }

    public void promptUserForAction() {
        System.out.println(menu);
    }

    private String composeMenu(){
        StringBuilder actionsDescription = new StringBuilder("Enter action (");
        for(Action action : actions) {
            actionsDescription.append(String.format("%d - %s, ", action.getId(), action.getDescription()));
        }
        actionsDescription.delete(actionsDescription.length() - 2, actionsDescription.length());
        actionsDescription.append("): ");

        return actionsDescription.toString();
    }

}
