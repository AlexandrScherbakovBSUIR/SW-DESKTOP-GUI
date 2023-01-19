package edu.easysoft.game.listener;

import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGroundOperationListener implements ActionListener {
    boolean visible;
    PlayGroundPainter playGroundPainter;
    String action;
    public PlayGroundOperationListener(PlayGroundPainter playGroundPainter,
                                       String action){
        this.playGroundPainter = playGroundPainter;
        this.action=action;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(action.equals("clean")){

            playGroundPainter.cleanUpPlayGround();

        } else if (action.equals("generate")) {

            playGroundPainter.generateTemplate();

        } else if (action.equals("show")) {

                playGroundPainter.showTablet();
        }
    }
}
