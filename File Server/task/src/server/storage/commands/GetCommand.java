package server.storage.commands;

import server.storage.Storage;
import server.storage.commands.CommandResult.Codes;
import server.storage.commands.CommandResult.CommandResult;
import server.storage.commands.CommandResult.CommandResultBuilder;

import java.util.List;
import java.util.Optional;

public class GetCommand extends Command {

    public GetCommand(Storage storage) {
        super(storage);
    }

    @Override
    public CommandResult execute() {
        Optional<List<String>> file = storage.getFile(context.getFilename());
        boolean isSuccess = file.isPresent();
        String message = getFormattedMessage(isSuccess);
        int code = getCode(isSuccess);
        String fileContent = isSuccess ? String.join("\n", file.get()) : "";

        return new CommandResultBuilder()
                .setCode(code)
                .setMessage(message)
                .setFileContent(fileContent)
                .build();
    }

    private String getFormattedMessage(boolean isSuccess) {
        String SUCCESS_MESSAGE = "The file %s was sent";
        String FAILURE_MESSAGE = "The file %s not found";
        return String.format(isSuccess ? SUCCESS_MESSAGE : FAILURE_MESSAGE, context.getFilename());
    }

    private int getCode(boolean isSuccess) {
        return isSuccess ? Codes.OK : Codes.NOT_FOUND;
    }
}
