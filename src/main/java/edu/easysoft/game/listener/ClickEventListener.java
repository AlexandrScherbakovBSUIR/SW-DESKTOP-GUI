package edu.easysoft.game.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickEventListener implements MouseListener {


    void saySomething(String eventDescription, MouseEvent e) {
        System.out.println(e.getX()+" "+ e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        saySomething("clicking",e);
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
