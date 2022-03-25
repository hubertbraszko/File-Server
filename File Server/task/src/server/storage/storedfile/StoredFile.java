package server.storage.storedfile;

public class StoredFile {

    private final String name;
    private final long id;
    private final byte[] content;

    public StoredFile(String name, long id, byte[] content) {
        this.name = name;
        this.id = id;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public byte[] getContent() {
        return content;
    }
}
