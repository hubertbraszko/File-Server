package server.storage.commands;

import server.storage.Storage;
import server.storage.commands.CommandResult.CommandResult;
import server.storage.commands.CommandResult.CommandResultBuilder;

public class ExitCommand extends Command{
    public ExitCommand(Storage storage) {
        super(storage);
    }

    @Override
    public CommandResult execute() {
        System.exit(0);
        return new CommandResultBuilder()
                .setCode(200)
                .setMessage("Server shutdown")
                .build();
    }
}
