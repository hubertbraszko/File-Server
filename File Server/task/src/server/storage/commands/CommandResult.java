package server.storage.commands;

import client.response.Response;

public class CommandResult {

    private final int code;
    private final String message;
    private String method;
    private String fileContent;

    //TODO fix this - change to builder pattern

    CommandResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.fileContent = "";
        this.method = "UNKNOWN";
    }

    CommandResult(int code, String message, String fileContent) {
        this(code, message);
        this.fileContent = fileContent;
    }

    CommandResult(int code, String message, String fileContent, String method) {
        this(code, message, fileContent);
        this.method = method;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Response toResponse() {
        return new Response(this.code, this.message, this.fileContent);
    }
}
