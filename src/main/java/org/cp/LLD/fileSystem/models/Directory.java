package org.cp.LLD.fileSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Directory extends IFile{
    List<IFile> listOfFiles;

    public Directory(boolean isFile, String name) {
        super(isFile, name);
        listOfFiles = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println("Current Directory is: " + this.name);
        for(IFile file: listOfFiles){
            file.ls();
        }
    }

    public void addFile(IFile file){
        this.listOfFiles.add(file);
    }
}
