package client.request;

import client.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private final String action;
    private final String fileName;
    private final String fileContent; //TODO temporary solution

    public Request(String action, String fileName) {
        this.action = action;
        this.fileName = fileName;
        this.fileContent = "";
    }

    public Request(String action, String fileName, String fileContent) {
        this.action = action;
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String getAction() {
        return action;
    }

    public String getFilename() {
        return fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    @Override
    public String toString() {
        String fileContentKeyValue = fileContent.isEmpty() ? "" : "fileContent: " + fileContent;
        return "action: " + action + ",\n" +
               "fileName: " + fileName + ",\n" +
               fileContentKeyValue;
    }

    public static Request parseRequest(String str) {
        String[] pairs = str.split(",\n");
        Map<String, String> responseMap = new HashMap<>();
        for(String pair : pairs) {
            String[] keyValue = pair.split(": ");
            if(keyValue.length > 1) {
                responseMap.put(keyValue[0], keyValue[1]);
            }
        }
        String action = responseMap.getOrDefault("action", "");
        String fileName = responseMap.getOrDefault("fileName", "");
        String fileContent = responseMap.getOrDefault("fileContent", "");

        return new Request(action, fileName, fileContent);
    }
}
