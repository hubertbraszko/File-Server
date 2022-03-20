package client.request;

public class Request {

    private final String fileName;
    private final String action;
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
       return "action: " + action + ",\n" +
               "fileName: " + fileName + ",\n" +
               "fileContent: " + fileContent;
    }
}
