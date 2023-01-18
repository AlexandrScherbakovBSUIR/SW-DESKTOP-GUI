package edu.easysoft.game;

import edu.easysoft.game.listener.ClickEventListener;
import edu.easysoft.game.playground.HexagonPainter;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        ClickEventListener clickEventListener = new ClickEventListener();
        GridLayout gridLayout = new GridLayout(3,3);
        gridLayout.setHgap(2);
        gridLayout.setVgap(2);
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JPanel jPanel = new JPanel();
        btn1.setSize(20,20);
        jPanel.add(btn1);
        btn2.setSize(20,20);
        btn3.setSize(20,20);
        btn4.setSize(20,20);
        btn5.setSize(20,20);


        JFrame frame = new JFrame("Star Wars: Bounty Haunters");
        HexagonPainter hexagonPainter = new HexagonPainter();
        hexagonPainter.addMouseListener(clickEventListener);


        frame.add(hexagonPainter);
        //frame.add(jPanel);


        //frame.setLayout(gridLayout);
        frame.setSize(1150, 700);
        frame.setResizable(false);
        frame.setVisible(true);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}