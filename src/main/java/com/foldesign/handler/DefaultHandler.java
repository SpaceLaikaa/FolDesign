package com.foldesign.handler;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DefaultHandler extends FileHandler{
    public DefaultHandler(Path folderPath) {
        super(folderPath);
    }

    @Override
    public void handle(Path filePath){
        Path targetFile = Paths.get(getFolderPath().toString(), filePath.getFileName().toString());

        copyFile(filePath,targetFile);
    }
}
