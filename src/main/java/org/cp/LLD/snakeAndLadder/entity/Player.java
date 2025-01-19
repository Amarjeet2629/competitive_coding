package org.cp.LLD.snakeAndLadder.entity;

public class Player {
    int id;
    String name;
    Position position;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        this.position = new Position(0, -1 );
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
