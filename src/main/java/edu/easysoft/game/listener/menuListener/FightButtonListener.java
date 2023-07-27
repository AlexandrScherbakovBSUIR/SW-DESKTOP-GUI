package edu.easysoft.game.listener.menuListener;

import edu.easysoft.game.client.MyStompSessionHandler;
import edu.easysoft.game.client.RestClient;
import edu.easysoft.game.playground.PlayGroundPainter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class FightButtonListener implements ActionListener {
    private final static String serverUrl = "ws://localhost:8082/chat";
    PlayGroundPainter playGroundPainter;
    RestClient restClient;

    public FightButtonListener(PlayGroundPainter playGroundPainter){
        this.playGroundPainter = playGroundPainter;


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        playGroundPainter.fight(throwDiceForFight());
/*
        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        stompClient.connect(serverUrl, sessionHandler);*/

        //restClient.postRequest(serverUrl,playGroundPainter.toJSON());

    }
    private int throwDiceForFight(){
        return (int) (Math.random()*7);
    }
}
