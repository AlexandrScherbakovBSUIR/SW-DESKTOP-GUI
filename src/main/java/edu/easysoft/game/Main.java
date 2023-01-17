package edu.easysoft.game;

import edu.easysoft.game.listener.ClickEventListener;
import edu.easysoft.game.playground.Hexagon;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GraphicsEnvironment graphics =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        JFrame frame = new JFrame("Star Wars: Bounty Haunters");
        frame.add(new Hexagon());
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setBackground(Color.LIGHT_GRAY);
        ClickEventListener clickEventListener = new ClickEventListener();

        frame.addMouseListener(clickEventListener);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jTextField = new JTextField();

        //device.setFullScreenWindow(frame);

    }
}