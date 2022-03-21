package client.ui.actions;

import client.request.Request;

import java.util.Scanner;

public class ExitAction extends Action {
    public ExitAction() {
        super(0, "exit");
        isVisibleInUI = false;
    }

    @Override
    public Request makeRequest(Scanner scanner) {
        return new Request("exit");
    }
}
