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
    public void execute(){
        boolean result = storage.addFile(file);
        String message = getFormattedMessage(result);
        System.out.println(message);
    }

    private String getFormattedMessage(boolean result) {
        String SUCCESS_MESSAGE = "The file %s added successfully";
        String FAILURE_MESSAGE = "Cannot add the file %s";
        return String.format(result ? SUCCESS_MESSAGE : FAILURE_MESSAGE, file.getName());
    }
}
