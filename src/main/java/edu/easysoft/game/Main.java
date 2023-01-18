package edu.easysoft.game;

import edu.easysoft.game.listener.ClickEventListener;
import edu.easysoft.game.playground.HexagonPainter;

import java.awt.*;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        createAndShowGUI();




    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("StarWars Bounty Haunter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        //frame.setSize(1280, 720);
        frame.setTitle(frame.getTitle() +"    "+ frame.getWidth() +"X"+ frame.getHeight());
        frame.setResizable(false);

        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container contentPane) {
        ClickEventListener clickEventListener = new ClickEventListener();

        GridBagLayout gridLayout = new GridBagLayout();

        GridBagConstraints constraintsPlayGround = new GridBagConstraints();
        //gridLayout.anchor
        constraintsPlayGround.fill = GridBagConstraints.RELATIVE;
        //constraintsPlayGround.ipady = 0;       //reset to default
        //constraintsPlayGround.weighty = 1.0;   //request any extra vertical space
        constraintsPlayGround.anchor = GridBagConstraints.NORTHWEST;
        constraintsPlayGround.insets = new Insets(10,10,10,10);  //top padding
        constraintsPlayGround.gridx = 0;       //aligned with button 2
        constraintsPlayGround.gridwidth = 3;
        constraintsPlayGround.gridheight = 3;
        constraintsPlayGround.gridy = 0;

        GridBagConstraints constraintsMenus = new GridBagConstraints();
        //gridLayout.anchor
        constraintsMenus.fill = GridBagConstraints.BOTH;
        //constraintsPlayGround.ipady = 0;       //reset to default
        constraintsPlayGround.weighty = 1.0;   //request any extra vertical space
        //constraintsPlayGround.anchor = GridBagConstraints.FIRST_LINE_START;

        constraintsPlayGround.insets = new Insets(5,5,5,5);  //top padding
        constraintsMenus.gridx = 3;       //aligned with button 2
        constraintsMenus.gridwidth = 1;
        constraintsMenus.gridheight = 3;
        constraintsMenus.gridy = 0;




/*        gridLayout.setHgap(2);
        gridLayout.setVgap(2);*/
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel jPanel5 = new JPanel();
        JPanel jPanel6 = new JPanel();
        btn1.setSize(20,20);
        btn2.setSize(20,20);
        btn3.setSize(20,20);
        btn4.setSize(20,20);
        btn5.setSize(20,20);





        HexagonPainter hexagonPainter = new HexagonPainter();
        hexagonPainter.addMouseListener(clickEventListener);
        hexagonPainter.setPreferredSize(new Dimension(850,650));
        jPanel2.add(btn2);
        jPanel2.add(btn3);
        jPanel2.add(btn4);
        jPanel.add(hexagonPainter);
        jPanel.setSize(hexagonPainter.getSize());
        jPanel.setBackground(Color.black);



        contentPane.setLayout(gridLayout);
        contentPane.add(jPanel,constraintsPlayGround);
        contentPane.setBackground(Color.gray);

        contentPane.add(jPanel2,constraintsMenus);
/*
        contentPane.add(jPanel3);
        contentPane.add(jPanel4);
        contentPane.add(jPanel5);
*/

        //contentPane.add(jPanel6);


    }
}