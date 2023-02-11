package edu.easysoft.game.playground;

import java.awt.*;

public class PlayGroundWalker {
    private Point location;
    private int trophy;


    public PlayGroundWalker(Point location){
        this.location=location;

    }


    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    public void increaseTrophy(int cellValue){
        trophy = trophy + cellValue;
        System.out.println(trophy);

    }

    public int getTrophy() {
        return trophy;
    }

    public void setTrophy(int trophy) {
        this.trophy = trophy;
    }
}
