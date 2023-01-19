package edu.easysoft.game.listener;

import edu.easysoft.game.playground.HexagonPainter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class ClickEventListener implements MouseListener, MouseMotionListener {

    void saySomething(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription +"::  "+ e.getPoint()+" "
                +e.getComponent().toString() );
        //System.out.println(e.getComponent().getGraphics());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        saySomething("clicking",e);
        Graphics2D graphic2d =(Graphics2D)e.getComponent().getGraphics();
        graphic2d.setColor(Color.orange);
        HexagonPainter hexagonPainter =(HexagonPainter) e.getComponent();

        //todo: do not return null!
        if(hexagonPainter.findClickedCell(e.getPoint())!=null)
            graphic2d.fillOval((int) (hexagonPainter.findClickedCell(e.getPoint()).getX()-hexagonPainter.getHexagonSize()*HexagonPainter.cos60)+5,
                (int)hexagonPainter.findClickedCell(e.getPoint()).getY()+5,
                (int) (hexagonPainter.getHexagonSize()*(2*HexagonPainter.cos60+1))-10,
                (int) ( 2 * hexagonPainter.getHexagonSize()*HexagonPainter.sin60)-10);



    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().setBackground(Color.GRAY);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        saySomething("dragged move",e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        saySomething("moving",e);

    }
}
