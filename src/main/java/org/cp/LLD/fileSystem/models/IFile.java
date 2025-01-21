package org.cp.LLD.fileSystem.models;

public abstract class IFile {
    boolean isFile;
    String name;

    public IFile(boolean isFile, String name){
        this.isFile = isFile;
        this.name = name;
    }

    public boolean getIsFile(){
        return this.isFile;
    }

    public String getName(){
        return this.name;
    }

    public abstract void ls();
}
