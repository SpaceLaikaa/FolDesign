package com.foldesign.handler;

import java.io.*;
import java.nio.file.Path;

public abstract class FileHandler {
    private Path folderPath;

    public FileHandler(Path folderPath){
        this.folderPath=folderPath;
    }

    public Path getFolderPath() {return folderPath;}

    public abstract void handle(Path filePath);

    public void copyFile(Path mainFolder, Path targetFolder){
        try(InputStream inputS = new FileInputStream(mainFolder.toFile());
             OutputStream outputS = new FileOutputStream(targetFolder.toFile())){ //toFile bc stream is an old java thing must turn path to file


        }
          catch (FileNotFoundException e) {
            System.out.println("File Not Found: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
