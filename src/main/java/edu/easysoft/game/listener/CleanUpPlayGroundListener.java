package edu.easysoft.game.listener;

import edu.easysoft.game.playground.HexagonPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanUpPlayGroundListener implements ActionListener {
    HexagonPainter hexagonPainter;
    String action;
    public CleanUpPlayGroundListener(HexagonPainter hexagonPainter,
                                     String action){
        this.hexagonPainter=hexagonPainter;
        this.action=action;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(action.equals("clean")){
            hexagonPainter.cleanUpPlayGround();
        } else if (action.equals("generate")) {
            hexagonPainter.generateTemplate();

        }


    }
}
