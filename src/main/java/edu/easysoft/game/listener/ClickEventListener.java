package edu.easysoft.game.listener;

import edu.easysoft.game.playground.HexagonPainter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickEventListener implements MouseListener {

    void saySomething(String eventDescription, MouseEvent e) {
        System.out.println( e.getPoint()+" "+e.getComponent() );
        //System.out.println(e.getComponent().getGraphics());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        saySomething("clicking",e);

        e.getComponent().getGraphics().setColor(Color.blue);
        //e.getComponent().getGraphics().fillOval(e.getX()-5,e.getY()-5,100,50);
        HexagonPainter hexagonPainter =(HexagonPainter) e.getComponent();

        e.getComponent().getGraphics().fillOval((int) (hexagonPainter.findClickedCell(e.getPoint()).getX()-hexagonPainter.getHexagonSize()*HexagonPainter.cos60)+5,
                (int)hexagonPainter.findClickedCell(e.getPoint()).getY()+5,
                (int) (hexagonPainter.getHexagonSize()*(2*HexagonPainter.cos60+1))-10,
                (int) ( 2 * hexagonPainter.getHexagonSize()*HexagonPainter.sin60)-10);


        System.out.println(e.getComponent().getGraphics().getColor());
        e.getComponent().getGraphics().setColor(Color.RED);
        System.out.println(e.getComponent().getGraphics().getColor());


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
}
