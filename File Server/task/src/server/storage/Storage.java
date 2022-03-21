package server.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


public class Storage {

    public boolean addFile(String fileName, String fileContent) {
        boolean result = false;

        String filePath = getRelativePathToFile(fileName);
        File file = new File(filePath);
        if(file.isFile()) {
            return false;
        }
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(fileContent);
            result = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            result = false;
        }

        return result;
    }

    public boolean deleteFile(String fileName) {
        String pathToFile = getRelativePathToFile(fileName);
        File fileToBeDeleted = new File(pathToFile);
        return fileToBeDeleted.delete();
    }

    public Optional<List<String>> getFile(String fileName) {
        String pathToFile = getRelativePathToFile(fileName);
        File file = new File(pathToFile);
        List<String> fileContent = null;
        if(file.isFile()) {
            try {
                fileContent = Files.readAllLines(Paths.get(pathToFile));
            } catch (IOException e) {
                System.out.println("Cant read file content");
            }
        }
        return Optional.ofNullable(fileContent);
    }

    private String getRelativePathToFile(String fileName) {
        String dataRelativePath = "/home/hubert/Projects/File Server/File Server/task/src/server/data/%s";
        return String.format(dataRelativePath, fileName);
    }
}
