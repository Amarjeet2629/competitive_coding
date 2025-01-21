package org.cp.LLD.fileSystem.models;

public class File extends IFile{
    StringBuilder content;

    public File(boolean isFile, String name) {
        super(isFile, name);
        content = new StringBuilder();
    }

    public String readContent() {
        return content.toString();
    }

    @Override
    public void ls() {
        System.out.println("FileName is: " + name);
    }

    public void addContent(String content){
        this.content.append(content);
    }
}
