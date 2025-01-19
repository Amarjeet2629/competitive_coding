package org.cp.LLD.snakeAndLadder.entity;

public class LadderPortal extends Portal{
    public LadderPortal(Position startPosition, Position endPosition) {
        super(startPosition, endPosition, PortalType.LADDER);
    }
}
