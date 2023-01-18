package edu.easysoft.game.playground;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class HexagonPainter extends JPanel {
    int hexagonSize = 30;
    Map<Point,Hexagon> hexagonMap = new HashMap<Point,Hexagon>();
    public static double sin60 = Math.sin(Math.toRadians(60));
    public static double cos60 = Math.cos(Math.toRadians(60));
    //x odd->even//y even->odd

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphic2d = (Graphics2D) g;
        graphic2d.setColor(Color.white);


        for(int x=40; x<=800; ){
            for(int y=40; y<=600;){
                paintHexagon(graphic2d, hexagonSize,x,y);
                y =(int)(y+2*Math.round(hexagonSize *sin60));
            }
            x = (int)( x + 2*(hexagonSize +Math.round(hexagonSize *cos60)));
        }
        for(int x = (int)(40+Math.round(hexagonSize *cos60)+ hexagonSize); x<=800; ){
            for(int y = (int) (40-Math.round(hexagonSize *sin60)); y<=600;
            ){
                paintHexagon(graphic2d, hexagonSize,x,y);
                y =(int)(y+2*Math.round(hexagonSize *sin60));
            }
            x = (int)( x + 2*(hexagonSize +Math.round(hexagonSize *cos60)));
        }

        //setBackground(Color.gray);
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
    }

    public void paintHexagon(Graphics g,int size,int x,int y){
        int x1=x;
        int y1=y;
        int x2=x+size;
        int y2=y;
        int x3=(int) Math.round(cos60*size + x +size);
        int y3= (int) Math.round(sin60*size+y);
        int x4=x+size;
        int y4= (int) Math.round((sin60*size+y+sin60*size));
        int x5=x;
        int y5= (int) Math.round((sin60*size+y+sin60*size));
        int x6=(int)Math.round((x-(cos60*size)));
        int y6= (int) Math.round((sin60*size+y));
        paintDoubleLine(g,x1,y1,x2,y2);
        paintDoubleLine(g,x2,y2,x3,y3);
        paintDoubleLine(g,x3,y3,x4,y4);
        paintDoubleLine(g,x4,y4,x5,y5);
        paintDoubleLine(g,x5,y5,x6,y6);
        paintDoubleLine(g,x6,y6,x1,y1);

        hexagonMap.put(new Point(x1,y1),
                new Hexagon(x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6));

    }
    public void paintDoubleLine(Graphics g,double x1,double y1,double x2,double y2){

        if (y1==y2){
            if( Math.round(y1) % 2 == 0){
                g.drawLine((int) Math.round(x1),(int)Math.round(y1),
                        (int)Math.round(x2),(int)Math.round(y2));
                g.drawLine((int)(Math.round(x1)),(int)(Math.round(y1)+1),
                        (int)(Math.round(x2)),(int)(Math.round(y2)+1));
            }else {
                g.drawLine((int) Math.round(x1),(int)Math.round(y1),
                        (int)Math.round(x2),(int)Math.round(y2));
                g.drawLine((int)(Math.round(x1)),(int)(Math.round(y1)-1),
                        (int)(Math.round(x2)),(int)(Math.round(y2)-1));
            }
        }else {
            g.drawLine((int) Math.round(x1), (int) Math.round(y1),
                    (int) Math.round(x2), (int) Math.round(y2));


        }
    }

    public Point findClickedCell(Point point){
        int difX=0;
        int difY=0;
        int x =  0;
        int y =  0;


        for (Point iterPoint:hexagonMap.keySet()) {

            //middle area
            if(point.getX()>iterPoint.getX()&&
                    point.getX()<iterPoint.getX() + hexagonSize &&
                    point.getY()>iterPoint.getY()
                    && point.getY()<iterPoint.getY()+ 2 * sin60*hexagonSize){
                return iterPoint;
            }
            if(point.getX() > iterPoint.getX() -cos60*hexagonSize &&
                    point.getX() < iterPoint.getX() &&
                    point.getY() > iterPoint.getY() &&
                    point.getY() < iterPoint.getY() + 2*sin60*hexagonSize ) {
                return iterPoint;
            }


        }

        return point;


    }

    public int getHexagonSize() {
        return hexagonSize;
    }

    public void setHexagonSize(int hexagonSize) {
        this.hexagonSize = hexagonSize;
    }
}
