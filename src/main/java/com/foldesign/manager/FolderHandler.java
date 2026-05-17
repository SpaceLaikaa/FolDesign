package com.foldesign.manager;

import com.foldesign.handler.FileHandler;

import java.io.File;
import java.util.HashMap;

public class FolderHandler {
    File myDownloadsFolder = new File("C:/Users/ardaa/İndirilenler");
    File[] downloadsFiles = myDownloadsFolder.listFiles();

    HashMap<String, FileHandler> factory = new HashMap<>();
}
