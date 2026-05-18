package com.foldesign.manager;

import com.foldesign.handler.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class FolderHandler {
    private final HashMap<String, FileHandler> factory;

    public FolderHandler(){
        this.factory = new HashMap<>();

        factory.put("jpeg" , new JpegHandler(Paths.get("C:\\Users\\ardaa\\Downloads\\Jpg_Folder")));
        factory.put("jpg" , new JpegHandler(Paths.get("C:\\Users\\ardaa\\Downloads\\Jpg_Folder")));
        factory.put("png", new PngHandler(Paths.get("C:\\Users\\ardaa\\Downloads\\Png_Folder")));
        factory.put("pdf", new PdfHandler(Paths.get("C:\\Users\\ardaa\\Downloads\\Pdf_Folder")));
        factory.put("exe", new ExeHandler(Paths.get("C:\\Users\\ardaa\\Downloads\\Exe_Folder")));

    }
    public void scanAndOrganise(){
        File myDownloadsFolder = new File("C:\\Users\\ardaa\\Downloads");
        File[] downloadsFiles = myDownloadsFolder.listFiles();

        if(downloadsFiles == null){System.out.println("Path Error: Null"); return;}

        for(File file : downloadsFiles){
            if(file.isFile()){
                String fileName = file.getName().toLowerCase();
                String[] parts = fileName.split("\\.");
                String extension = parts[parts.length-1];

                FileHandler toCorrectHandler = factory.get(extension);
                if (toCorrectHandler != null){
                    toCorrectHandler.handle(file.toPath());
                }
            }
        }
    }
}
