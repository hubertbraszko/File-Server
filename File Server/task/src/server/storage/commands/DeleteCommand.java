package server.storage.commands;

import server.storage.Storage;

public class DeleteCommand extends Command {

    private final String fileName;

    public DeleteCommand(Storage storage, String fileName) {
        super(storage);
        this.fileName = fileName;
    }

    @Override
    public CommandResult execute() {
        boolean isSuccess = storage.deleteFile(fileName);
        String message = getFormattedMessage(isSuccess);
        int code = getCode(isSuccess);

        return new CommandResult(code, message);
    }

    private String getFormattedMessage(boolean isSuccess) {
        String SUCCESS_MESSAGE = "The file %s was deleted";
        String FAILURE_MESSAGE = "The file %s not found";
        return String.format(isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE, fileName);
    }

    private int getCode(boolean isSuccess) {
        return isSuccess ? Codes.OK : Codes.NOT_FOUND;
    }
}
