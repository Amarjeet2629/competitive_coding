package org.cp.LLD.treeCreation;

import org.cp.LLD.treeCreation.entity.*;
import org.cp.LLD.treeCreation.service.TreeGenerator;


public class Main {
    public static void main(String ...args){
        TreeGenerator treeGenerator = new TreeGenerator();


        for(Tree tree: treeGenerator.getRandomTrees(10000)){
            System.out.println(tree);
        }
    }
}
