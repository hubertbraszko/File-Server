package server.storage.commands;

import server.storage.Storage;

import java.io.File;
import java.util.Optional;

public class GetCommand extends Command {

    private final String fileName;

    public GetCommand(Storage storage, String fileName) {
        super(storage);
        this.fileName = fileName;
    }

    @Override
    public CommandResult execute() {
        Optional<File> file = storage.getFile(fileName);
        boolean isSuccess = file.isPresent();
        String message = getFormattedMessage(isSuccess);
        int code = getCode(isSuccess);
        return isSuccess ? new CommandResult(code, message, file.get()) : new CommandResult(code, message);
    }

    private String getFormattedMessage(boolean isSuccess) {
        String SUCCESS_MESSAGE = "The file %s was sent";
        String FAILURE_MESSAGE = "The file %s not found";
        return String.format(isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE, fileName);
    }

    private int getCode(boolean isSuccess) {
        return isSuccess ? Codes.OK : Codes.NOT_FOUND;
    }
}
