package client.response;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private final int code;
    private final String message;
    private final String fileContent;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
        this.fileContent = "";
    }

    public Response(int code, String message, String fileContent) {
        this.code = code;
        this.message = message;
        this.fileContent = fileContent;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static Response parseResponse(String str) {
        String[] pairs = str.split(",\n");
        Map<String, String> responseMap = new HashMap<>();
        for(String pair : pairs) {
            String[] keyValue = pair.split(": ");
            if(keyValue.length > 1) {
                responseMap.put(keyValue[0], keyValue[1]);
            }
        }
        int code = Integer.parseInt(responseMap.getOrDefault("code", "400"));
        String message = responseMap.getOrDefault("message", "Something went wrong");
        String fileContent = responseMap.getOrDefault("fileContent", "");

        return new Response(code, message, fileContent);
    }

    @Override
    public String toString() {
        String fileContentKeyValue = fileContent.isEmpty() ? "" : "fileContent: " + fileContent;
        return "code: " + code + ",\n" +
                "message: " + message + ",\n" +
                fileContentKeyValue;
    }
}
