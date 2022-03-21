package server.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Storage {

    private final List<File> storedFiles = new ArrayList<>();
    private final int MAX_NUMBER_OF_FILES = 10;
    public boolean addFile(String fileName, String fileContent) {
        if(!containsFileWithName(fileName)) {
            String filePath = String.format("File Server/task/src/server/data/%s", fileName);
            File file = new File(filePath);
            try(FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(fileContent);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
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
