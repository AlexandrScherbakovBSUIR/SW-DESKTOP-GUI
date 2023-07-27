package edu.easysoft.game.client;
import edu.easysoft.game.playground.PlayGroundPainter;
import edu.easysoft.game.playground.PlayGroundWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.awt.*;
import java.lang.reflect.Type;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);
    PlayGroundPainter playGroundPainter;

    public MyStompSessionHandler(PlayGroundPainter playGroundPainter) {
        this.playGroundPainter = playGroundPainter;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
/*        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/messages", this);
        logger.info("Subscribed to /topic/messages");
        session.send("/app/chat", getSampleMessage());
        logger.info("Message sent to websocket server");*/


        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/walker", this);
        logger.info("Subscribed to /topic/walker");
        session.send("/app/game", getGameStateMessage());
        logger.info("Message sent to websocket server");

    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return GameStateMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        //Message msg = (Message) payload;
        System.out.println(payload.getClass());
        GameStateMessage msg = (GameStateMessage) payload;

        logger.info(payload.getClass() );
        playGroundPainter.setPlayGroundWalker(((GameStateMessage) payload).getPlayGroundWalker());
        playGroundPainter.repaint();
    }

    /**
     * A sample message instance.
     * @return instance of <code>Message</code>
     */
/*    private Message getSampleMessage() {
        Message msg = new Message();
        msg.setFrom("Nicky");
        msg.setText("Howdy!!");
        return msg;
    }*/

    private GameStateMessage getGameStateMessage(){
        GameStateMessage gameStateMessage = new GameStateMessage();
        gameStateMessage.setPlayGroundWalker(playGroundPainter.getPlayGroundWalker());

        return gameStateMessage;
    }
}