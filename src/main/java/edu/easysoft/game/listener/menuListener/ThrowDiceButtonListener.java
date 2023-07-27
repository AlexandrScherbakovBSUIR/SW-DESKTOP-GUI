package edu.easysoft.game.listener.menuListener;

import edu.easysoft.game.client.RestClient;
import edu.easysoft.game.playground.PlayGroundPainter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThrowDiceButtonListener implements ActionListener {
    private final int step = 2;
    PlayGroundPainter playGroundPainter;
    RestClient restClient;
    public ThrowDiceButtonListener(PlayGroundPainter playGroundPainter, RestClient restClient){
        this.playGroundPainter = playGroundPainter;
        this.restClient = restClient;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int step = throwDice();
        playGroundPainter.showPath(step);
        playGroundPainter.repaint();
        restClient.postRequest("https://www.google.com/",playGroundPainter.toJSON());

    }

    public int throwDice(){
        return (int) (Math.random()*step + 2);

    }
}
