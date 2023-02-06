package edu.easysoft.game.playground;

import java.awt.*;

public class PlayGroundWalker {
    private Point location;


    public PlayGroundWalker(Point location){
        this.location=location;

    }


    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
