package server.storage;

import java.io.File;
import java.util.List;
import java.util.Optional;


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

    public Optional<File> getFile(String name) {
        return storedFiles.stream()
                .filter(file -> name.equals(file.getName()))
                .findFirst();
    }

    private boolean containsFileWithName(String name) {
        return storedFiles.stream()
                .anyMatch(file -> file.getName().equals(name));
    }
}
