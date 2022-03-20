package client.ui.actions;

import client.request.Request;

import java.util.Scanner;

public abstract class Action {

    private final int id;
    private final String description;

    protected Action(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract Request makeRequest(Scanner scanner);

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
