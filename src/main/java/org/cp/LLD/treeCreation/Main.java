package org.cp.LLD.treeCreation;

import org.cp.LLD.treeCreation.entity.*;
import org.cp.LLD.treeCreation.service.TreeGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String ...args){
        TreeGenerator treeGenerator = new TreeGenerator();

        List<Tree> listOfTrees = new ArrayList<>();
        HashMap<Tree, Integer> generatedTrees = new HashMap<>();

        for(int i = 0; i < 10000; i++){
            TreeBuilder treeBuilder = new TreeBuilder();

            treeBuilder
                    .setBark(Bark.getRandom())
                    .setLeafColor(LeafColor.getRandom())
                    .setLength(Length.getRandom());

            Tree tree = treeGenerator.generateTree(treeBuilder);

            if(!generatedTrees.containsKey(tree)){
                listOfTrees.add(treeGenerator.generateTree(treeBuilder));
                generatedTrees.put(tree, 1);
            }

        }

        for(Tree tree:  listOfTrees){
            System.out.println(tree);
        }
    }
}
