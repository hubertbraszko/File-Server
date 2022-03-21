package server.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;


public class Storage {

    public boolean addFile(String fileName, String fileContent) {
        boolean result = false;

        String filePath = getRelativePathToFile(fileName);
        File file = new File(filePath);
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

    public Optional<File> getFile(String fileName) {
        String pathToFile = getRelativePathToFile(fileName);
        File file = new File(pathToFile).isFile() ? new File(pathToFile) : null;

        return Optional.ofNullable(file);
    }

    private String getRelativePathToFile(String fileName) {
        String dataRelativePath = "File Server/task/src/server/data/%s";
        return String.format(dataRelativePath, fileName);
    }
}
