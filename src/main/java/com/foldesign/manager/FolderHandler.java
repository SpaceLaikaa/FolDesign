package com.foldesign.manager;

import com.foldesign.handler.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;

public class FolderHandler {
    private HashMap<String, FileHandler> factory;

    public FolderHandler(){
        this.factory = new HashMap<>();

        factory.put("jpeg" , new JpegHandler(Paths.get("İndirilenler/Jpg_Folder")));
        factory.put("jpg" , new JpegHandler(Paths.get("İndirilenler/Jpg_Folder")));
        factory.put("png", new PngHandler(Paths.get("İndirilenler/Png_Folder")));
        factory.put("pdf", new PdfHandler(Paths.get("İndirilenler/Pdf_Folder")));
        factory.put("exe", new ExeHandler(Paths.get("İndirilenler/Pdf_Folder")));
    }
    public void scanAndOrganise(){
        File myDownloadsFolder = new File("C:/Users/ardaa/İndirilenler");
        File[] downloadsFiles = myDownloadsFolder.listFiles();

        if(downloadsFiles == null){System.out.println("Path Error: Null"); return;}

        for(File file : downloadsFiles){
            if(file.isFile()){
                String fileName = file.getName().toLowerCase();

            }
        }
    }
}
