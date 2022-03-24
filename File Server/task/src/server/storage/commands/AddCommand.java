package server.storage.commands;

import server.storage.Storage;
import server.storage.commands.CommandResult.Codes;
import server.storage.commands.CommandResult.CommandResult;
import server.storage.commands.CommandResult.CommandResultBuilder;

public class AddCommand extends Command {

    public AddCommand(Storage storage) {
        super(storage);
    }

    @Override
    public CommandResult execute(){
        boolean isSuccess = storage.addFile(context.getFilename(), context.getFileContent());
        String message = getFormattedMessage(isSuccess);
        int code = getCode(isSuccess);

        return new CommandResultBuilder()
                .setCode(code)
                .setMessage(message)
                .build();
    }

    private String getFormattedMessage(boolean isSuccess) {
        String SUCCESS_MESSAGE = "The file %s added successfully";
        String FAILURE_MESSAGE = "Cannot add the file %s";
        return String.format(isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE, context.getFilename());
    }

    private int getCode(boolean isSuccess) {
        return isSuccess ? Codes.OK : Codes.FORBIDDEN;
    }
}
