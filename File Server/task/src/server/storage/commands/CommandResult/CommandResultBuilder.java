package server.storage.commands.CommandResult;

public class CommandResultBuilder {
    private int code = 500;
    private String message = "";
    private String method = "UNKNOWN";
    private String fileContent = "";

    public CommandResultBuilder setCode(int code) {
        this.code = code;
        return this;
    }

    public CommandResultBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public CommandResultBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    public CommandResultBuilder setFileContent(String fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    public CommandResult build() {
        return new CommandResult(code, message, method, fileContent);
    }
}