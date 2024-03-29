package edu.easysoft.game.playground;

import edu.easysoft.game.comparator.PointComparator;
import edu.easysoft.game.tablet.Tablet;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class PlayGroundPainter extends JPanel {
    int hexagonSize = 30;
    boolean tableVisibility;
    int count = 0;
    private Tablet tablet = new Tablet();



    private PlayGroundWalker  playGroundWalker;
    private PlayGroundWalker enemyWalker;
    Map<Point,Cell> cellMap = new HashMap<>();
    public static double sin60 = Math.sin(Math.toRadians(60));
    public static double cos60 = Math.cos(Math.toRadians(60));

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphic2d = (Graphics2D) g;
        graphic2d.setColor(Color.black);


        //drawing playground for X
        for(int x=40; x<=800; ){
            for(int y=40; y<=600;){
                paintHexagon(graphic2d, hexagonSize,x,y);
                y =(int)(y+2*Math.round(hexagonSize *sin60));
            }
            x = (int)( x + 2*(hexagonSize +Math.round(hexagonSize *cos60)));
        }
        //drawing playground for Y
        for(int x = (int)(40+Math.round(hexagonSize *cos60)+ hexagonSize); x<=800; ){
            for(int y = (int) (40-Math.round(hexagonSize *sin60)); y<=600;
            ){
                paintHexagon(graphic2d, hexagonSize,x,y);
                y =(int)(y+2*Math.round(hexagonSize *sin60));
            }
            x = (int)( x + 2*(hexagonSize +Math.round(hexagonSize *cos60)));
        }
        graphic2d.setColor(Color.darkGray);

        //sort it by Y then by X
        cellMap = cellMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(new PointComparator()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Point point: cellMap.keySet()) {

            if(cellMap.get(point).isBarrier()){
                graphic2d.fillOval((int) (point.getX()-getHexagonSize()* PlayGroundPainter.cos60)+5,
                        (int)point.getY()+5,
                        (int) (getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                        (int) ( 2 * getHexagonSize()* PlayGroundPainter.sin60)-10);
            }
            //draw the path after throw dices
            if(cellMap.get(point).isOnThePath()){
                graphic2d.drawOval((int) (point.getX()-getHexagonSize()* PlayGroundPainter.cos60)+5,
                        (int)point.getY()+5,
                        (int) (getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                        (int) ( 2 * getHexagonSize()* PlayGroundPainter.sin60)-10);
            }
            if(cellMap.get(point).isMouseMoved()){
                graphic2d.drawOval((int) (point.getX()-getHexagonSize()* PlayGroundPainter.cos60)+5,

                        (int)point.getY()+5,
                        (int) (getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                        (int) ( 2 * getHexagonSize()* PlayGroundPainter.sin60)-10);
                cellMap.get(point).setMouseMoved(false);
            }
        }
        //drawing player onto playground
        graphic2d.setColor(Color.red);
        graphic2d.fillOval((int) (enemyWalker.getLocation().getX()-getHexagonSize()* PlayGroundPainter.cos60)+5,
                (int)enemyWalker.getLocation().getY()+5,
                (int) (getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                (int) ( 2 * getHexagonSize()* PlayGroundPainter.sin60)-10);
        graphic2d.setColor(Color.blue);
        graphic2d.fillOval((int) (playGroundWalker.getLocation().getX()-getHexagonSize()* PlayGroundPainter.cos60)+5,
                (int)playGroundWalker.getLocation().getY()+5,
                (int) (getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                (int) ( 2 * getHexagonSize()* PlayGroundPainter.sin60)-10);

        graphic2d.setColor(Color.darkGray);


        //todo: why does it work?
        if(count <1){
            tablet.setVisible(false);
            tablet.setBackground(Color.getHSBColor(140,70,20));

            tablet.setPreferredSize(new Dimension(300,200));

            tablet.setLocation(100,100);
            this.add(tablet);
            //this.setLayout(null);
            count++;
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


        if(!cellMap.containsKey(new Point(x1,y1))) {

            cellMap.put(new Point(x1, y1),new Cell(new Hexagon(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6),1));

            if(playGroundWalker==null){
                playGroundWalker = new PlayGroundWalker(new Point(x1,y1));
            }
            if(enemyWalker==null){
                enemyWalker = new PlayGroundWalker(new Point(x1,y1));
            }
        }


    }
    public void paintDoubleLine(Graphics g,double x1,double y1,double x2,double y2){
        //x odd->even
        //y even->odd
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

        for (Point iterPoint:cellMap.keySet()) {

            //middle area
            if(point.getX()>=iterPoint.getX()
                    && point.getX()<=iterPoint.getX() + hexagonSize
                    && point.getY()>=iterPoint.getY()
                    && point.getY()<=iterPoint.getY()+ 2 * sin60*hexagonSize
                    && cellMap.get(iterPoint).isOnThePath()){
                moveWalker(iterPoint);

                return iterPoint;
            }
            //left area
            if(point.getX() >= iterPoint.getX() -cos60*hexagonSize &&
                    point.getX() <= iterPoint.getX() &&
                    point.getY() >= iterPoint.getY() &&
                    point.getY() <= iterPoint.getY() + 2*sin60*hexagonSize &&
                    cellMap.get(iterPoint).isOnThePath()) {
                moveWalker(iterPoint);


                return iterPoint;
            }
        }
        return null;
    }
    public Point findMovedCell(Point point){
        for (Point iterPoint:cellMap.keySet()) {

            //middle area
            if(point.getX()>=iterPoint.getX()&&
                    point.getX()<=iterPoint.getX() + hexagonSize &&
                    point.getY()>=iterPoint.getY()
                    && point.getY()<=iterPoint.getY()+ 2 * sin60*hexagonSize){
                cellMap.get(iterPoint).setMouseMoved(true);
                super.repaint();
                return iterPoint;
            }
            //left area
            if(point.getX() >= iterPoint.getX() -cos60*hexagonSize &&
                    point.getX() <= iterPoint.getX() &&
                    point.getY() >= iterPoint.getY() &&
                    point.getY() <= iterPoint.getY() + 2*sin60*hexagonSize ) {
                cellMap.get(iterPoint).setMouseMoved(true);
                super.repaint();
                return iterPoint;
            }


        }
        return null;
    }
    public void cleanUpMovedCell() {
        for (Cell cell :cellMap.values()) {
            cell.setMouseMoved(false);
        }
        super.repaint();
    }


    public  void cleanUpPlayGround(){
        for (Cell cell:cellMap.values()) {

            cell.setBarrier(false);
            cell.setOnThePath(false);

        }
        super.repaint();
    }

    public void generateTemplate() {
        for (Cell cell:cellMap.values()) {
            if(Math.random()< 0.15){
                cell.setBarrier(true);
            }else{
                cell.setBarrier(false);
            }
        }
        super.repaint();
    }




    public void showPath(int step) {
        //todo: step from Walker
        findNearCell(playGroundWalker.getLocation(),step);
    }

    private void findNearCell(Point point, int step) {
        List<Point> pointList = new ArrayList<>();
        if(step>0){


            if(point.getX() - (hexagonSize + Math.round(hexagonSize * cos60))>=40
                && point.getY() + Math.round(hexagonSize * sin60)<=586 )
                pointList.add(findMovedCell(new Point(
                        (int) (point.getX() - ((hexagonSize + Math.round(hexagonSize * cos60)))),
                        (int) (point.getY() + Math.round(hexagonSize * sin60)))));

            if(point.getX() - (hexagonSize + Math.round(hexagonSize * cos60))>=40
                && point.getY() - Math.round(hexagonSize * sin60)>=14)
                pointList.add(findMovedCell(new Point(
                        (int) (point.getX() - ((hexagonSize + Math.round(hexagonSize * cos60)))),
                        (int) (point.getY() - Math.round(hexagonSize * sin60)))));

            if(point.getX() + ((hexagonSize + Math.round(hexagonSize * cos60)))<=760
                && point.getY() + Math.round(hexagonSize * sin60)<=586)
                pointList.add(findMovedCell(new Point(
                        (int) (point.getX() + ((hexagonSize + Math.round(hexagonSize * cos60)))),
                        (int) (point.getY() + Math.round(hexagonSize * sin60)))));

            if(point.getX() + ((hexagonSize + Math.round(hexagonSize * cos60)))<=760
                && point.getY() - Math.round(hexagonSize * sin60)>=14)
                pointList.add(findMovedCell(new Point(
                        (int) (point.getX() + ((hexagonSize + Math.round(hexagonSize * cos60)))),
                        (int) (point.getY() - Math.round(hexagonSize * sin60)))));

            if(point.getY() + 2 * Math.round(hexagonSize * sin60)<=586)
                pointList.add(findMovedCell(new Point(
                        (int) (point.getX()),
                        (int) (point.getY() + 2 * Math.round(hexagonSize * sin60)))));

            if(point.getY() - 2 * Math.round(hexagonSize * sin60) >= 14)
                pointList.add(findMovedCell(new Point(
                        (int) (point.getX()),
                        (int) (point.getY() - 2 * Math.round(hexagonSize * sin60)))));



            for (Point iterPoint: pointList) {
                int iterStep = step-1;
                if (!iterPoint.equals(playGroundWalker.getLocation())) {
                    if(cellMap.get(iterPoint).isBarrier()==false)
                    cellMap.get(iterPoint).setOnThePath(true);
                }
                if(cellMap.get(iterPoint).isBarrier()==false)
                findNearCell(iterPoint,iterStep);
            }
        }

    }

    public void moveWalker(Point point){
        //cellMap.get(playGroundWalker.getLocation()).setSelected(false);
        playGroundWalker.setLocation(point);
        fight(5);

        for (Cell cell: cellMap.values()) {
            cell.setOnThePath(false);

        }
        super.repaint();

    }
    public void fight(int power){
        playGroundWalker.increaseTrophy(cellMap.get(playGroundWalker.getLocation()).getValue());
        cellMap.get(playGroundWalker.getLocation()).setValue(0);
    }
    public void spy(){
        String name = JOptionPane.showInputDialog(this,
                "What is your name?", "enemy name");
        JOptionPane.showMessageDialog(this,name);

    }

    public void showTablet() {

        //todo: store tablet as field, create their oun class to process tablet
        tablet.setVisible(revertVisibility(tableVisibility));
        tablet.setBackground(Color.getHSBColor(140,70,20));
        tablet.setLocation(100,100);

        this.add(tablet);
        super.repaint();
    }
    public void  repaint(){
        super.repaint();
    }
    public boolean revertVisibility(boolean visible){
        this.tableVisibility = ! visible;
        return this.tableVisibility;
    }

    public boolean isTableVisibility() {
        return tableVisibility;
    }

    public void setTableVisibility(boolean tableVisibility) {
        this.tableVisibility = tableVisibility;
    }
    public int getHexagonSize() {
        return hexagonSize;
    }

    public void setHexagonSize(int hexagonSize) {
        this.hexagonSize = hexagonSize;
    }

    public PlayGroundWalker getPlayGroundWalker() {
        return playGroundWalker;
    }

    public void setPlayGroundWalker(PlayGroundWalker playGroundWalker) {
        this.playGroundWalker = playGroundWalker;
    }

    public String toJSON() {
        System.out.println("{\"count\":\"" + playGroundWalker.getTrophy() + "!\"}");
        return "{\"count\":\"" + playGroundWalker.getTrophy() + "!\"}";

    }


}
