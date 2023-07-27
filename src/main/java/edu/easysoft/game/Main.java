package edu.easysoft.game;

import edu.easysoft.game.client.MyStompSessionHandler;
import edu.easysoft.game.mainframe.FramePainter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class Main {
    private final static String serverUrl = "ws://localhost:8080/chat";

    public static void main(String[] args) {

        FramePainter.createAndShowGUI();



        //new Scanner(System.in).nextLine(); // Don't close immediately.
    }
}