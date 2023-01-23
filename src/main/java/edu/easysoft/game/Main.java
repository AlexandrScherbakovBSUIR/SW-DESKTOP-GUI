package edu.easysoft.game;

import edu.easysoft.game.listener.PlayGroundOperationListener;
import edu.easysoft.game.listener.ClickEventListener;
import edu.easysoft.game.playground.PlayGroundPainter;
import edu.easysoft.game.tablet.Card;

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
        frame.setResizable(false);
        frame.setVisible(true);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setTitle(frame.getTitle() +"    "+ frame.getWidth() +"X"+ frame.getHeight());

    }

    private static void addComponentsToPane(Container contentPane) {
        ClickEventListener clickEventListener = new ClickEventListener();

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagLayout menuButtonGridBagLayout = new GridBagLayout();

        GridBagConstraints constraintsPlayGround = new GridBagConstraints();
        constraintsPlayGround.fill = GridBagConstraints.RELATIVE;
        constraintsPlayGround.anchor = GridBagConstraints.NORTHWEST;
        constraintsPlayGround.gridx = 0;
        constraintsPlayGround.gridy = 0;
        constraintsPlayGround.gridwidth = 3;
        constraintsPlayGround.gridheight = 3;


        GridBagConstraints constraintsButtonPanel = new GridBagConstraints();
        constraintsButtonPanel.fill = GridBagConstraints.BOTH;
        constraintsPlayGround.weighty = 1.0;   //request any extra vertical space
        constraintsPlayGround.insets = new Insets(5,5,5,5);  //top padding
        constraintsButtonPanel.gridx = 3;       //aligned with button 2
        constraintsButtonPanel.gridy = 0;
        constraintsButtonPanel.gridwidth = 1;
        constraintsButtonPanel.gridheight = 3;




        GridBagConstraints generateButtonConstraints = new GridBagConstraints();
        generateButtonConstraints.fill = GridBagConstraints.BOTH;
        generateButtonConstraints.weighty = 1.0;   //request any extra vertical space
        generateButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        generateButtonConstraints.gridx = 0;       //aligned with button 2
        generateButtonConstraints.gridy = 0;
        generateButtonConstraints.gridwidth = 1;
        generateButtonConstraints.gridheight = 1;

        GridBagConstraints cleanButtonConstraints = new GridBagConstraints();
        cleanButtonConstraints.fill = GridBagConstraints.BOTH;
        cleanButtonConstraints.weighty = 1.0;   //request any extra vertical space
        cleanButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        cleanButtonConstraints.gridx = 0;       //aligned with button 2
        cleanButtonConstraints.gridy = 1;
        cleanButtonConstraints.gridwidth = 1;
        cleanButtonConstraints.gridheight = 1;

        GridBagConstraints showButtonConstraints = new GridBagConstraints();
        showButtonConstraints.fill = GridBagConstraints.BOTH;
        showButtonConstraints.weighty = 1.0;   //request any extra vertical space
        showButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        showButtonConstraints.gridx = 1;       //aligned with button 2
        showButtonConstraints.gridy = 0;
        showButtonConstraints.gridwidth = 1;
        showButtonConstraints.gridheight = 2;



        GridBagConstraints spyButtonConstraints = new GridBagConstraints();
        spyButtonConstraints.fill = GridBagConstraints.BOTH;
        spyButtonConstraints.weighty = 1.0;   //request any extra vertical space
        spyButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        spyButtonConstraints.gridx = 0;       //aligned with button 2
        spyButtonConstraints.gridy = 2;
        spyButtonConstraints.gridwidth = 1;
        spyButtonConstraints.gridheight = 1;

        GridBagConstraints diplomacyButtonConstraints = new GridBagConstraints();
        diplomacyButtonConstraints.fill = GridBagConstraints.BOTH;
        diplomacyButtonConstraints.weighty = 1.0;   //request any extra vertical space
        diplomacyButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        diplomacyButtonConstraints.gridx = 1;       //aligned with button 2
        diplomacyButtonConstraints.gridy = 2;
        diplomacyButtonConstraints.gridwidth = 1;
        diplomacyButtonConstraints.gridheight = 1;

        GridBagConstraints throwDiceButtonConstraints = new GridBagConstraints();
        throwDiceButtonConstraints.fill = GridBagConstraints.BOTH;
        throwDiceButtonConstraints.weighty = 1.0;   //request any extra vertical space
        throwDiceButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        throwDiceButtonConstraints.gridx = 0;       //aligned with button 2
        throwDiceButtonConstraints.gridy = 3;
        throwDiceButtonConstraints.gridwidth = 1;
        throwDiceButtonConstraints.gridheight = 1;

        GridBagConstraints fightButtonConstraints = new GridBagConstraints();
        fightButtonConstraints.fill = GridBagConstraints.BOTH;
        fightButtonConstraints.weighty = 1.0;   //request any extra vertical space
        fightButtonConstraints.insets = new Insets(5,5,5,5);  //top padding
        fightButtonConstraints.gridx = 1;       //aligned with button 2
        fightButtonConstraints.gridy = 3;
        fightButtonConstraints.gridwidth = 1;
        fightButtonConstraints.gridheight = 1;

        GridBagConstraints ammunitionConstraints = new GridBagConstraints();
        ammunitionConstraints.fill = GridBagConstraints.BOTH;
        ammunitionConstraints.weighty = 1.0;   //request any extra vertical space
        ammunitionConstraints.insets = new Insets(5,5,5,5);  //top padding
        ammunitionConstraints.gridx = 0;       //aligned with button 2
        ammunitionConstraints.gridy = 4;
        ammunitionConstraints.gridwidth = 1;
        ammunitionConstraints.gridheight = 2;

        GridBagConstraints vehicleConstraints = new GridBagConstraints();
        vehicleConstraints.fill = GridBagConstraints.BOTH;
        vehicleConstraints.weighty = 1.0;   //request any extra vertical space
        vehicleConstraints.insets = new Insets(5,5,5,5);  //top padding
        vehicleConstraints.gridx = 1;       //aligned with button 2
        vehicleConstraints.gridy = 4;
        vehicleConstraints.gridwidth = 1;
        vehicleConstraints.gridheight = 2;

        JButton generateButton = new JButton("Generate template");
        generateButton.setPreferredSize(new Dimension(75,50));
        JButton cleanButton = new JButton("Clean Up");
        cleanButton.setPreferredSize(new Dimension(75,50));
        JButton showTabletButton = new JButton("show Tablet");
        JButton spyButton = new JButton("spy");
        JButton diplomacyButton = new JButton("diplomacy");
        JButton throwDiceButton = new JButton("throw dice");
        JButton fightButton = new JButton("fight");
        JPanel ammunitionPanel = new JPanel();
        ammunitionPanel.setBackground(Color.orange);
        ammunitionPanel.setPreferredSize(new Dimension(50,75));
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setBackground(Color.orange);
        vehiclePanel.setPreferredSize(new Dimension(50,75));

        JPanel buttonPlanel = new JPanel();

        JPanel jPanel = new JPanel();

        PlayGroundPainter playGroundPainter = new PlayGroundPainter();
        PlayGroundOperationListener cleanUpPlayGroundListener =
                new PlayGroundOperationListener(playGroundPainter, "clean");
        PlayGroundOperationListener generateActionListener =
                new PlayGroundOperationListener(playGroundPainter,"generate");
        PlayGroundOperationListener showActionListener =
                new PlayGroundOperationListener(playGroundPainter,"show");

        cleanButton.addActionListener(cleanUpPlayGroundListener);
        generateButton.addActionListener(generateActionListener);
        showTabletButton.addActionListener(showActionListener);

        playGroundPainter.addMouseListener(clickEventListener);
        playGroundPainter.addMouseMotionListener(clickEventListener);
        playGroundPainter.setPreferredSize(new Dimension(850,650));
        buttonPlanel.setLayout(menuButtonGridBagLayout);
        buttonPlanel.add(generateButton,generateButtonConstraints);
        buttonPlanel.add(cleanButton,cleanButtonConstraints);
        buttonPlanel.add(showTabletButton,showButtonConstraints);

        buttonPlanel.add(spyButton,spyButtonConstraints);
        buttonPlanel.add(diplomacyButton,diplomacyButtonConstraints);

        buttonPlanel.add(throwDiceButton,throwDiceButtonConstraints);
        buttonPlanel.add(fightButton,fightButtonConstraints);

        buttonPlanel.add(ammunitionPanel,ammunitionConstraints);
        buttonPlanel.add(vehiclePanel,vehicleConstraints);


        jPanel.add(playGroundPainter);
        jPanel.setSize(playGroundPainter.getSize());
        jPanel.setBackground(Color.black);

        contentPane.setLayout(gridBagLayout);
        contentPane.add(jPanel,constraintsPlayGround);
        contentPane.setBackground(Color.gray);

        contentPane.add(buttonPlanel,constraintsButtonPanel);

    }
}