package server.storage.commands;

import server.storage.Storage;

public class ExitCommand extends Command{
    public ExitCommand(Storage storage) {
        super(storage);
    }

    @Override
    public CommandResult execute() {
        System.exit(0);
        return new CommandResult(200, "Server shutdown");
    }
}
