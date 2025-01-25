package org.cp.LLD.treeCreation.entity;

import java.util.Objects;

public class Tree {
    Length length;
    Bark bark;
    LeafColor leafColor;

    public Tree(TreeBuilder treeBuilder){
        this.bark = treeBuilder.bark;
        this.leafColor = treeBuilder.leafColor;
        this.length = treeBuilder.length;
    }

    @Override
    public String toString(){
        return "[ Tree Length: " + this.length + ", Bark: " + this.bark + ", Leaf Color: " + this.leafColor + " ]";
    }

    @Override
    public boolean equals(Object object){
        if(object == null || object.getClass() != getClass()) return false;
        Tree objectTree = (Tree) object;

        if(objectTree.leafColor != this.leafColor) return false;
        if(objectTree.bark != this.bark) return false;
        return objectTree.length == this.length;
    }

    @Override
    public int hashCode(){
        return Objects.hash(bark, leafColor, length);
    }
}
