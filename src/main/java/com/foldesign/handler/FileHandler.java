package com.foldesign.handler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class FileHandler {
    private Path folderPath;

    public FileHandler(Path folderPath){
        this.folderPath=folderPath;
    }

    public Path getFolderPath() {return folderPath;}

    public abstract void handle(Path filePath);

    public void copyFile(Path mainFile, Path targetFile){
        boolean isCopySuccessful = false;

        try(InputStream inputS = new FileInputStream(mainFile.toFile());
             OutputStream outputS = new FileOutputStream(targetFile.toFile())){ //toFile bc stream is an old java thing must turn path to file

            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = inputS.read(buffer)) != -1){
                outputS.write(buffer, 0, bytesRead);
            }
            System.out.println(mainFile.getFileName()+" successfully moved to -> "+targetFile.getFileName());
            isCopySuccessful=true;
        }
          catch (FileNotFoundException e) {
            System.out.println("File Not Found: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(isCopySuccessful){
            try{
                Files.delete(mainFile);
            } catch (IOException e) {
                System.out.println("Source File copied but didn't remove source file");
            }
        }


    }
}
