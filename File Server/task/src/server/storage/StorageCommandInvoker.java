package server.storage;

import server.storage.commands.Command;
import server.storage.commands.CommandResult.CommandResult;

public class StorageCommandInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public CommandResult executeCommand() {
        return command.execute();
    }
}
