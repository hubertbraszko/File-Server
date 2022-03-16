package server.storage.commands;

import server.storage.Storage;

import java.io.File;

public class DeleteCommand extends Command {

    private final String fileName;

    public DeleteCommand(Storage storage, String fileName) {
        super(storage);
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        boolean result = storage.deleteFile(fileName);
        String message = getFormattedMessage(result);
        System.out.println(message);
    }

    private String getFormattedMessage(boolean result) {
        String SUCCESS_MESSAGE = "The file %s was deleted";
        String FAILURE_MESSAGE = "The file %s not found";
        return String.format(result ? SUCCESS_MESSAGE : FAILURE_MESSAGE, fileName);
    }
}
