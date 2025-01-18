package org.cp.LLD.treeCreation.entity;

public class TreeBuilder {
    Length length;
    Bark bark;
    LeafColor leafColor;

    public TreeBuilder(){

    }

    public TreeBuilder setLength(Length length){
        this.length = length;
        return this;
    }

    public TreeBuilder setLeafColor(LeafColor leafColor){
        this.leafColor = leafColor;
        return this;
    }

    public TreeBuilder setBark(Bark bark){
        this.bark = bark;
        return this;
    }

    public Tree build(){
        return new Tree(this);
    }
}
