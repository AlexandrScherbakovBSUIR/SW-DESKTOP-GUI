package edu.easysoft.game.listener.menuListener;

import edu.easysoft.game.client.SimpleClient;
import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThrowDiceButtonListener implements ActionListener {
    private final int step = 2;
    PlayGroundPainter playGroundPainter;
    SimpleClient simpleClient =new SimpleClient();
    public ThrowDiceButtonListener(PlayGroundPainter playGroundPainter,SimpleClient simpleClient){
        this.playGroundPainter = playGroundPainter;
        this.simpleClient = simpleClient;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int step = throwDice();
        playGroundPainter.showPath(step);
        playGroundPainter.repaint();
        simpleClient.postRequest("https://www.google.com/",playGroundPainter.toJSON());

    }

    public int throwDice(){
        return (int) (Math.random()*step + 2);

    }
}
