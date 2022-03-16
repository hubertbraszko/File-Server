package server.storage.commands;

import server.storage.Storage;

import java.io.File;
import java.util.Optional;

public class GetCommand extends Command {

    private final String fileName;

    private File resultFile;

    public GetCommand(Storage storage, String fileName) {
        super(storage);
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        boolean result = storage.getFile(fileName);
        String message = getFormattedMessage(result);
        System.out.println(message);
    }

    private String getFormattedMessage(boolean result) {
        String SUCCESS_MESSAGE = "The file %s was sent";
        String FAILURE_MESSAGE = "The file %s not found";
        return String.format(result ? SUCCESS_MESSAGE : FAILURE_MESSAGE, fileName);
    }
}
