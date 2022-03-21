package server.storage.commands;

import client.request.Request;
import server.storage.Storage;

public class DeleteCommand extends Command {

    public DeleteCommand(Storage storage) {
        super(storage);
    }

    @Override
    public CommandResult execute() {
        boolean isSuccess = storage.deleteFile(context.getFilename());
        String message = getFormattedMessage(isSuccess);
        int code = getCode(isSuccess);

        return new CommandResult(code, message);
    }

    private String getFormattedMessage(boolean isSuccess) {
        String SUCCESS_MESSAGE = "The file %s was deleted";
        String FAILURE_MESSAGE = "The file %s not found";
        return String.format(isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE, context.getFilename());
    }

    private int getCode(boolean isSuccess) {
        return isSuccess ? Codes.OK : Codes.NOT_FOUND;
    }
}
