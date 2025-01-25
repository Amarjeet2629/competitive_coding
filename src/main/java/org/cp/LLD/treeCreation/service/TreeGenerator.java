package org.cp.LLD.treeCreation.service;

import org.cp.LLD.treeCreation.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeGenerator {
    public TreeGenerator(){

    }

    private Tree generateTree(TreeBuilder treeBuilder){
        return treeBuilder.build();
    }

    public List<Tree> getRandomTrees(int N){
        List<Tree> listOfTrees = new ArrayList<>();
        HashMap<Tree, Integer> generatedTrees = new HashMap<>();

        for(int i = 0; i < N; i++){
            TreeBuilder treeBuilder = new TreeBuilder();

            treeBuilder
                    .setBark(Bark.getRandom())
                    .setLeafColor(LeafColor.getRandom())
                    .setLength(Length.getRandom());

            Tree tree = generateTree(treeBuilder);

            if(!generatedTrees.containsKey(tree)){
                generatedTrees.put(tree, 1);
                listOfTrees.add(tree);
            }

        }

        return listOfTrees;
    }
}
