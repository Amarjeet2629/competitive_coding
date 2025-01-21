package org.cp.LLD.fileSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Node {
    IFile dirInfo;
    List<Node> children;

    public Node(IFile dirInfo){
        this.dirInfo = dirInfo;
        children = new ArrayList<>();

    }

    public void addToChildren(Node child){
        children.add(child);
    }

    public IFile getNodeData(){
        return this.dirInfo;
    }

    public List<Node> getChildren() {
        return children;
    }
}
