package org.cp.LLD.snakeAndLadder.entity;

public class SnakePortal extends Portal{
    public SnakePortal(Position startPosition, Position endPosition) {
        super(startPosition, endPosition, PortalType.SNAKE);
    }
}
