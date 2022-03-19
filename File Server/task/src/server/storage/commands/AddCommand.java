package server.storage.commands;

import server.storage.Storage;

import java.io.File;

public class AddCommand extends Command {

    private final File file;

    public AddCommand(Storage storage, File file) {
        super(storage);
        this.file = file;
    }

    @Override
    public CommandResult execute(){
        boolean isSuccess = storage.addFile(file);
        String message = getFormattedMessage(isSuccess);
        int code = getCode(isSuccess);

        return new CommandResult(code, message);
    }

    private String getFormattedMessage(boolean isSuccess) {
        String SUCCESS_MESSAGE = "The file %s added successfully";
        String FAILURE_MESSAGE = "Cannot add the file %s";
        return String.format(isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE, file.getName());
    }

    private int getCode(boolean isSuccess) {
        return isSuccess ? Codes.OK : Codes.FORBIDDEN;
    }
}
