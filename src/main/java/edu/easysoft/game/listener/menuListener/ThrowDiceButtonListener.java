package edu.easysoft.game.listener.menuListener;

import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThrowDiceButtonListener implements ActionListener {
    private final int step = 2;
    PlayGroundPainter playGroundPainter;
    public ThrowDiceButtonListener(PlayGroundPainter playGroundPainter){
        this.playGroundPainter = playGroundPainter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int step = throwDice();
        playGroundPainter.showPath(step);

    }

    public int throwDice(){
        return (int) (Math.random()*step + 2);

    }
}
