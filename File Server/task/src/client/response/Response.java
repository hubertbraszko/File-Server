package client.response;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private final int code;
    private final String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
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
            responseMap.put(keyValue[0], keyValue[1]);
        }
        int code = Integer.parseInt(responseMap.getOrDefault("code", "400"));
        String message = responseMap.getOrDefault("message", "Something went wrong");

        return new Response(code, message);
    }
}
