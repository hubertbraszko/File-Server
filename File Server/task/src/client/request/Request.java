package client.request;

public class Request {

    private final String filename;
    private final String action;
    private final String fileContent; //TODO temporary solution

    public Request(String action, String filename) {
        this.action = action;
        this.filename = filename;
        this.fileContent = "";
    }

    public Request(String action, String filename, String fileContent) {
        this.action = action;
        this.filename = filename;
        this.fileContent = fileContent;
    }

    public String getAction() {
        return action;
    }

    public String getFilename() {
        return filename;
    }

    public String getFileContent() {
        return fileContent;
    }
}
