package edu.easysoft.game.listener.menuListener;

import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightButtonListener implements ActionListener {
    PlayGroundPainter playGroundPainter;

    public FightButtonListener(PlayGroundPainter playGroundPainter){
        this.playGroundPainter = playGroundPainter;


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        playGroundPainter.fight(throwDiceForFight());

    }
    private int throwDiceForFight(){
        return (int) (Math.random()*7);
    }
}
