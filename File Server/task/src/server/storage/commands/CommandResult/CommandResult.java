package server.storage.commands.CommandResult;

import client.response.Response;

public class CommandResult {

    private final int code;
    private final String message;
    private final String method;
    private final String fileContent;


    CommandResult(int code, String message, String method, String fileContent) {
        this.code = code;
        this.message = message;
        this.method = method;
        this.fileContent = fileContent;
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

    public String getMethod() {
        return method;
    }
}
