package org.cp.LLD.fileSystem.service;

public interface IFileSystem {
    public void mkdir(String path);
    public void writePath(String path, String content);
    public String readFile(String path);
    public void ls();
}
