package com.foldesign.handler;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PngHandler extends FileHandler{
    public PngHandler(Path folderPath) {
        super(folderPath);
    }

    @Override
    public void handle(Path filePath){
        Path targetFile = Paths.get(getFolderPath().toString(), filePath.getFileName().toString());

        copyFile(filePath,targetFile);
    }
}
