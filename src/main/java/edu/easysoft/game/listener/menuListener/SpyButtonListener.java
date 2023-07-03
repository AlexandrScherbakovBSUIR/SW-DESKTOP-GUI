package edu.easysoft.game.listener.menuListener;

import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpyButtonListener implements ActionListener {
    PlayGroundPainter playGroundPainter;
    public SpyButtonListener(PlayGroundPainter playGroundPainter) {
        this.playGroundPainter= playGroundPainter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playGroundPainter.spy();

    }
}
