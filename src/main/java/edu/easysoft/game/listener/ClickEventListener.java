package edu.easysoft.game.listener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickEventListener implements MouseListener {


    void saySomething(String eventDescription, MouseEvent e) {
        System.out.println(e.getX()+" "+ e.getY()+" "+ e.getPoint()+" "+e.getSource().getClass()+" "+e.getComponent().getBackground() );
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        saySomething("clicking",e);

       e.getComponent().setBackground(Color.ORANGE);
       //e.getComponent().repaint();
       //e.getComponent().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
