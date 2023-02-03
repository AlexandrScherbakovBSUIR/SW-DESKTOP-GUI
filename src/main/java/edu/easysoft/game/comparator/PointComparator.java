package edu.easysoft.game.comparator;

import java.awt.*;
import java.util.Comparator;

public class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point point1, Point point2) {

        if (point1.equals(point2)){
            return 0;
        } else if (point1.getY() == point2.getY()) {
            if (point1.getX() > point2.getX()){
                return 1;
            } else {
                return -1;
            }
        } else if (point1.getY() > point2.getY()) {
            return 1;
        } else {
            return -1;
        }
    }
}
