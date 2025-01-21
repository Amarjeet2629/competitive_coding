package org.cp.LLD.fileSystem.service.impl;

import org.cp.LLD.fileSystem.models.Directory;
import org.cp.LLD.fileSystem.models.File;
import org.cp.LLD.fileSystem.models.IFile;
import org.cp.LLD.fileSystem.models.Node;
import org.cp.LLD.fileSystem.service.IFileSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileSystem implements IFileSystem {
    private final Node root;

    public FileSystem(){
        root = new Node(new Directory(false, "/"));
    }

    @Override
    public void mkdir(String path) {
        List<String> pathParams = Arrays.stream(path.split("/")).toList();
        try {
            Node node = traverse(pathParams.subList(0, pathParams.size() - 1), 0, root);
            IFile newDir = new Directory(false, pathParams.get(pathParams.size() - 1));
            Node nodeForNewDir = new Node(newDir);
            node.addToChildren(nodeForNewDir);
            Directory directory = (Directory) node.getNodeData();
            directory.addFile(newDir);

        } catch (RuntimeException e) {
           System.out.println(e.getMessage());
        }
    }

    @Override
    public void writePath(String path, String content) {
        List<String> pathParams = Arrays.stream(path.split("/")).toList();
        try {
            Node node = traverse(pathParams.subList(0, pathParams.size() - 1), 0, root);
            List<Node> nodeList = node.getChildren().
                    stream().filter(child -> Objects.equals(child.getNodeData().getName(), pathParams.get(pathParams.size() - 1)))
                    .toList();

            if(nodeList.isEmpty()){
                File file = new File(true, pathParams.get(pathParams.size() - 1));
                file.addContent(content);

                Node newNode = new Node(file);
                node.addToChildren(newNode);
            } else {
                File file = (File) nodeList.get(0).getNodeData();
                file.addContent(content);
            }

        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

    }

    public String readFile(String path){
        List<String> pathParams = Arrays.stream(path.split("/")).toList();
        try {
            Node node = traverse(pathParams.subList(0, pathParams.size() - 1), 0, root);
            List<Node> nodeList = node.getChildren().
                    stream().filter(child -> Objects.equals(child.getNodeData().getName(), pathParams.get(pathParams.size() - 1)))
                    .toList();

            if(!nodeList.isEmpty()){
                return ((File) nodeList.get(0).getNodeData()).readContent();
            }

            throw new RuntimeException("File doesn't exits");

        } catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

        return null;
    }

    private Node traverse(List<String> pathParams, int depth, Node node){
        if(depth == pathParams.size() - 1) return node;

        List<Node> children = node.getChildren();
        for(Node child: children){
            if(!child.getNodeData().getIsFile() && child.getNodeData().getName().equals(pathParams.get(depth + 1))){
                return traverse(pathParams, depth + 1, child);
            }
        }

        throw new RuntimeException("Specified Path doesn't exits");
    }


    public void ls(){
        root.getNodeData().ls();
    }
}
