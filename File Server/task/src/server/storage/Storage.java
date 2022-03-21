package server.storage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Storage {

    private final List<File> storedFiles = new ArrayList<>();
    private final int MAX_NUMBER_OF_FILES = 10;

    public boolean addFile(String fileName, String fileContent) {
        if((storedFiles.size() < MAX_NUMBER_OF_FILES) && fileName.matches("file[0-9](0)?") && !containsFileWithName(fileName)) {
            return storedFiles.add(new File("S")); //TODO
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
