package edu.easysoft.game.playground;

import edu.easysoft.game.tablet.Card;
import edu.easysoft.game.tablet.Tablet;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PlayGroundPainter extends JPanel {
    int hexagonSize = 30;
    boolean tableVisibility;
    private Tablet tablet = new Tablet();
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
        graphic2d.setColor(Color.black);


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
        graphic2d.setColor(Color.darkGray);
        for (Point point: hexagonMap.keySet()) {
            if(hexagonMap.get(point).isSelected()){
                graphic2d.fillOval((int) (point.getX()-getHexagonSize()* PlayGroundPainter.cos60)+5,
                        (int)point.getY()+5,
                        (int) (getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                        (int) ( 2 * getHexagonSize()* PlayGroundPainter.sin60)-10);
            }

        }

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

        if(!hexagonMap.containsKey(new Point(x1,y1))) {
            hexagonMap.put(new Point(x1, y1),
                    new Hexagon(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6));
        }
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
            if(point.getX()>=iterPoint.getX()&&
                    point.getX()<=iterPoint.getX() + hexagonSize &&
                    point.getY()>=iterPoint.getY()
                    && point.getY()<=iterPoint.getY()+ 2 * sin60*hexagonSize){
                hexagonMap.get(iterPoint).setSelected(true);

                return iterPoint;
            }
            //left area
            if(point.getX() >= iterPoint.getX() -cos60*hexagonSize &&
                    point.getX() <= iterPoint.getX() &&
                    point.getY() >= iterPoint.getY() &&
                    point.getY() <= iterPoint.getY() + 2*sin60*hexagonSize ) {
                hexagonMap.get(iterPoint).setSelected(true);

                return iterPoint;
            }


        }

        return null;


    }
    public Point findMovedCell(Point point){
        int difX=0;
        int difY=0;
        int x =  0;
        int y =  0;


        for (Point iterPoint:hexagonMap.keySet()) {

            //middle area
            if(point.getX()>=iterPoint.getX()&&
                    point.getX()<=iterPoint.getX() + hexagonSize &&
                    point.getY()>=iterPoint.getY()
                    && point.getY()<=iterPoint.getY()+ 2 * sin60*hexagonSize){
                hexagonMap.get(iterPoint).setMouseMoved(true);

                return iterPoint;
            }
            //left area
            if(point.getX() >= iterPoint.getX() -cos60*hexagonSize &&
                    point.getX() <= iterPoint.getX() &&
                    point.getY() >= iterPoint.getY() &&
                    point.getY() <= iterPoint.getY() + 2*sin60*hexagonSize ) {
                hexagonMap.get(iterPoint).setMouseMoved(true);

                return iterPoint;
            }


        }

        return null;


    }

    public int getHexagonSize() {
        return hexagonSize;
    }

    public void setHexagonSize(int hexagonSize) {
        this.hexagonSize = hexagonSize;
    }
    public  void cleanUpPlayGround(){
        for (Hexagon hexagon:hexagonMap.values()) {
            hexagon.setSelected(false);

        }
        super.repaint();
    }

    public void generateTemplate() {
        for (Hexagon hexagon:hexagonMap.values()) {
            if(Math.random()< 0.15){
                hexagon.setSelected(true);
            }else{
                hexagon.setSelected(false);
            }


        }
        super.repaint();
    }

    public void showTablet() {

        //todo: store tablet as field, create their oun class to process tablet
        this.remove(tablet);




        tablet.setSize(new Dimension(600,400));
        tablet.setVisible(revertVisibility(tableVisibility));
        tablet.setBackground(Color.getHSBColor(100,100,100));
        tablet.setLocation(100,100);

        for (Card card : tablet.getCardList()) {
            //card.add(new JLabel(new ImageIcon("./src/main/resources/image/card/card_0.png","description of card 0")));

            tablet.add(card);

        }

        this.add(tablet);


        super.repaint();

    }
    public boolean revertVisibility(boolean visible){
        this.tableVisibility = ! visible;
        System.out.println(this.tableVisibility);

        return this.tableVisibility;
    }

    public boolean isTableVisibility() {
        return tableVisibility;
    }

    public void setTableVisibility(boolean tableVisibility) {
        this.tableVisibility = tableVisibility;
    }
}
