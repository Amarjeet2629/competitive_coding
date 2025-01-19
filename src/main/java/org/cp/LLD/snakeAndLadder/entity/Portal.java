package org.cp.LLD.snakeAndLadder.entity;

public abstract class Portal {
    Position startPosition;
    Position endPosition;
    PortalType portalType;

    public Portal(Position startPosition, Position endPosition, PortalType portalType){
        this.endPosition = endPosition;
        this.startPosition = startPosition;
        this.portalType = portalType;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public PortalType getPortalType() {
        return portalType;
    }
}
