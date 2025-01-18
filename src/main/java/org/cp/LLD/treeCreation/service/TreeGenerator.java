package org.cp.LLD.treeCreation.service;

import org.cp.LLD.treeCreation.entity.Tree;
import org.cp.LLD.treeCreation.entity.TreeBuilder;

public class TreeGenerator {
    public TreeGenerator(){

    }

    public Tree generateTree(TreeBuilder treeBuilder){
        return treeBuilder.build();
    }
}
