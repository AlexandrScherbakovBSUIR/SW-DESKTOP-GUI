package edu.easysoft.game.playground;

import javax.swing.*;
import java.awt.*;
import java.math.*;

public class Hexagon extends JPanel {
    double sin60 = Math.sin(Math.toRadians(60));
    double cos60 = Math.cos(Math.toRadians(60));

    @Override
    public void paint(Graphics g) {
        Graphics2D graphic2d = (Graphics2D) g;
        graphic2d.setColor(Color.BLACK);

        graphic2d.setColor(Color.black);
/*        graphic2d.drawLine(200, 274, 100, 274);  //y even->odd

        graphic2d.drawLine(101, 300, 101, 400);  //x odd->even*/
        int size = 30;
        for(int x=40; x<=800; x = (int)( x + 2*(size+Math.round(size*cos60)))){
            for(int y=40; y<=600; y =(int)(y+2*Math.round(size*sin60))){
                paintHexagon(graphic2d, size,x,y);
                ;
            } ;
        }
        for(int x=(int)(40+Math.round(size*cos60)+size); x<=800; x = (int)( x + 2*(size+Math.round(size*cos60)))){
            for(int y = (int) (40-Math.round(size*sin60)); y<=600; y =(int)(y+2*Math.round(size*sin60))){
                paintHexagon(graphic2d, size,x,y);
                ;
            } ;
        }




    }
    public void paintHexagon(Graphics g,int size,int x,int y){



        paintDoubleLine(g,x,y,x+size,y);
        paintDoubleLine(g,x+size, y, ((cos60*size) + x +size), (sin60*size+y));
        paintDoubleLine(g, ((cos60*size) + x +size), (sin60* size + y) ,x+size, (sin60*size+y+sin60*size));
        paintDoubleLine(g,x+size, (sin60*size+y+sin60*size),x, (sin60*size+y+sin60*size));
        paintDoubleLine(g,x, (sin60*size+y+sin60*size),(x-(cos60*size)), (sin60*size+y+sin60));
        paintDoubleLine(g,(x-(cos60*size)), (sin60*size+y+sin60),x,y);

    }
    public void paintDoubleLine(Graphics g,double x1,double y1,double x2,double y2){


        if (y1==y2){
            if( Math.round(y1) % 2 == 0){
                g.drawLine((int) Math.round(x1),(int)Math.round(y1),(int)Math.round(x2),(int)Math.round(y2));
                g.drawLine((int)(Math.round(x1)),(int)(Math.round(y1)+1),(int)(Math.round(x2)),(int)(Math.round(y2)+1));
            }else {
                g.drawLine((int) Math.round(x1),(int)Math.round(y1),(int)Math.round(x2),(int)Math.round(y2));
                g.drawLine((int)(Math.round(x1)),(int)(Math.round(y1)-1),(int)(Math.round(x2)),(int)(Math.round(y2)-1));

            }


        }else {
            g.drawLine((int) Math.round(x1), (int) Math.round(y1), (int) Math.round(x2), (int) Math.round(y2));


        }
    }

}
