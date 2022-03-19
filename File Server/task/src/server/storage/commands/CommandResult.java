package server.storage.commands;

import java.io.File;
import java.util.Optional;

public class CommandResult {

    private final int code;
    private final String message;
    private File file;


    CommandResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.file = null;
    }

    CommandResult(int code, String message, File file) {
        this(code,message);
        this.file = file;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Optional<File> getFile() {
        return Optional.ofNullable(file);
    }
}
