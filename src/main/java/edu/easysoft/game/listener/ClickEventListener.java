package edu.easysoft.game.listener;

import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ClickEventListener implements MouseListener, MouseMotionListener {

    void mouseEventCheck(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription +"::  "+ e.getPoint());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        mouseEventCheck("clicking",e);
        Graphics2D graphic2d =(Graphics2D)e.getComponent().getGraphics();
        graphic2d.setColor(Color.darkGray);
        PlayGroundPainter playGroundPainter =(PlayGroundPainter) e.getComponent();

        //todo: do not return null!
        if(!playGroundPainter.isTableVisibility())
            if(playGroundPainter.findClickedCell(e.getPoint())!=null)
                graphic2d.fillOval((int) (playGroundPainter.findClickedCell(e.getPoint()).getX()- playGroundPainter.getHexagonSize()* PlayGroundPainter.cos60)+5,
                (int) playGroundPainter.findClickedCell(e.getPoint()).getY()+5,
                (int) (playGroundPainter.getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                (int) ( 2 * playGroundPainter.getHexagonSize()* PlayGroundPainter.sin60)-10);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEventCheck("make darker",e);
        e.getComponent().setBackground(Color.lightGray);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseEventCheck("make lighter",e);

        e.getComponent().setBackground(Color.GRAY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseEventCheck("dragged move",e);

        Graphics2D graphic2d =(Graphics2D)e.getComponent().getGraphics();
        graphic2d.setColor(Color.red);
        PlayGroundPainter playGroundPainter =(PlayGroundPainter) e.getComponent();

        //todo: do not return null!
        if(!playGroundPainter.isTableVisibility())
            if(playGroundPainter.findMovedCell(e.getPoint())!=null)
                graphic2d.drawOval((int) (playGroundPainter.findMovedCell(e.getPoint()).getX()
                                - playGroundPainter.getHexagonSize()* PlayGroundPainter.cos60)+5,
                        (int) playGroundPainter.findMovedCell(e.getPoint()).getY()+5,
                        (int) (playGroundPainter.getHexagonSize()*(2* PlayGroundPainter.cos60+1))-10,
                        (int) ( 2 * playGroundPainter.getHexagonSize()* PlayGroundPainter.sin60)-10);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseEventCheck("moving",e);

        Graphics2D graphic2d =(Graphics2D)e.getComponent().getGraphics();
        graphic2d.setColor(Color.orange);
        PlayGroundPainter hexagonPainter =(PlayGroundPainter) e.getComponent();

        //todo: do not return null!
        if(!hexagonPainter.isTableVisibility())
            if(hexagonPainter.findMovedCell(e.getPoint())!=null)
                graphic2d.drawOval((int) (hexagonPainter.findMovedCell(e.getPoint()).getX()
                                -hexagonPainter.getHexagonSize()*PlayGroundPainter.cos60)+5,
                    (int)hexagonPainter.findMovedCell(e.getPoint()).getY()+5,
                    (int) (hexagonPainter.getHexagonSize()*(2*PlayGroundPainter.cos60+1))-10,
                    (int) ( 2 * hexagonPainter.getHexagonSize()*PlayGroundPainter.sin60)-10);
    }
}
