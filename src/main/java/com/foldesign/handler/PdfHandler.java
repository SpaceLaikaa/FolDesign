package com.foldesign.handler;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PdfHandler extends FileHandler{
    public PdfHandler(Path folderPath) {
        super(folderPath);
    }

    @Override
    public void handle(Path filePath){
        Path targetFile = Paths.get(getFolderPath().toString(), filePath.getFileName().toString());

        copyFile(filePath,targetFile);
    }
}
