package server.storage;

import java.io.File;
import java.util.List;


public class Storage {

    private final List<File> storedFiles;

    private final int MAX_NUMBER_OF_FILES = 10;

    public Storage(List<File> files){
        this.storedFiles = files;
    }

    public boolean addFile(File file) {
        if((storedFiles.size() < MAX_NUMBER_OF_FILES) && file.getName().matches("file[0-9](0)?") && !containsFileWithName(file.getName())) {
            return storedFiles.add(file);
        }
        return false;
    }

    public boolean deleteFile(String name) {
        return storedFiles.removeIf(file -> file.getName().equals(name));
    }

    public boolean getFile(String name) {
        return containsFileWithName(name);
        //TODO
    }

    private boolean containsFileWithName(String name) {
        return storedFiles.stream()
                .anyMatch(file -> file.getName().equals(name));
    }
}
