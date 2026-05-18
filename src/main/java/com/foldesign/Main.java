package com.foldesign;

import com.foldesign.manager.FolderHandler;

public class Main {
    public static void main(String[] args) {
        FolderHandler manager = new FolderHandler();

        manager.scanAndOrganise();
    }
}
