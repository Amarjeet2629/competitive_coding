package org.cp.LLD.snakeAndLadder.entity;

public class Slot {
    Position position;
    Portal portal;

    public Slot(Position position, Portal portal){
        this.portal = portal;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal){
        this.portal = portal;
    }
}
