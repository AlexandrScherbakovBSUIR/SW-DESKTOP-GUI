package edu.easysoft.game.mainframe;

import edu.easysoft.game.listener.MousePlayGroundEventListener;
import edu.easysoft.game.listener.PlayGroundOperationListener;
import edu.easysoft.game.playground.PlayGroundPainter;

import javax.swing.*;
import java.awt.*;

public final class  FramePainter {
    private FramePainter(){};

    public static void createAndShowGUI() {
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

    public static void addComponentsToPane(Container contentPane) {
        MousePlayGroundEventListener clickEventListener = new MousePlayGroundEventListener();

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
        constraintsPlayGround.weighty = 1.0;
        constraintsPlayGround.insets = new Insets(5,5,5,5);
        constraintsButtonPanel.gridx = 3;
        constraintsButtonPanel.gridy = 0;
        constraintsButtonPanel.gridwidth = 1;
        constraintsButtonPanel.gridheight = 3;

        GridBagConstraints showButtonConstraints = new GridBagConstraints();
        showButtonConstraints.fill = GridBagConstraints.BOTH;
        showButtonConstraints.weighty = 1.0;
        showButtonConstraints.insets = new Insets(5,5,5,5);
        showButtonConstraints.gridx = 0;
        showButtonConstraints.gridy = 0;
        showButtonConstraints.gridwidth = 2;
        showButtonConstraints.gridheight = 1;

        GridBagConstraints generateButtonConstraints = new GridBagConstraints();
        generateButtonConstraints.fill = GridBagConstraints.BOTH;
        generateButtonConstraints.weighty = 1.0;
        generateButtonConstraints.insets = new Insets(5,5,5,5);
        generateButtonConstraints.gridx = 1;
        generateButtonConstraints.gridy = 1;
        generateButtonConstraints.gridwidth = 1;
        generateButtonConstraints.gridheight = 1;

        GridBagConstraints cleanButtonConstraints = new GridBagConstraints();
        cleanButtonConstraints.fill = GridBagConstraints.BOTH;
        cleanButtonConstraints.weighty = 1.0;
        cleanButtonConstraints.insets = new Insets(5,5,5,5);
        cleanButtonConstraints.gridx = 0;
        cleanButtonConstraints.gridy = 1;
        cleanButtonConstraints.gridwidth = 1;
        cleanButtonConstraints.gridheight = 1;

        GridBagConstraints spyButtonConstraints = new GridBagConstraints();
        spyButtonConstraints.fill = GridBagConstraints.BOTH;
        spyButtonConstraints.weighty = 1.0;
        spyButtonConstraints.insets = new Insets(5,5,5,5);
        spyButtonConstraints.gridx = 0;
        spyButtonConstraints.gridy = 2;
        spyButtonConstraints.gridwidth = 1;
        spyButtonConstraints.gridheight = 1;

        GridBagConstraints diplomacyButtonConstraints = new GridBagConstraints();
        diplomacyButtonConstraints.fill = GridBagConstraints.BOTH;
        diplomacyButtonConstraints.weighty = 1.0;
        diplomacyButtonConstraints.insets = new Insets(5,5,5,5);
        diplomacyButtonConstraints.gridx = 1;
        diplomacyButtonConstraints.gridy = 2;
        diplomacyButtonConstraints.gridwidth = 1;
        diplomacyButtonConstraints.gridheight = 1;

        GridBagConstraints throwDiceButtonConstraints = new GridBagConstraints();
        throwDiceButtonConstraints.fill = GridBagConstraints.BOTH;
        throwDiceButtonConstraints.weighty = 1.0;
        throwDiceButtonConstraints.insets = new Insets(5,5,5,5);
        throwDiceButtonConstraints.gridx = 0;
        throwDiceButtonConstraints.gridy = 3;
        throwDiceButtonConstraints.gridwidth = 1;
        throwDiceButtonConstraints.gridheight = 1;

        GridBagConstraints fightButtonConstraints = new GridBagConstraints();
        fightButtonConstraints.fill = GridBagConstraints.BOTH;
        fightButtonConstraints.weighty = 1.0;
        fightButtonConstraints.insets = new Insets(5,5,5,5);
        fightButtonConstraints.gridx = 1;
        fightButtonConstraints.gridy = 3;
        fightButtonConstraints.gridwidth = 1;
        fightButtonConstraints.gridheight = 1;

        GridBagConstraints endTurnButtonConstraints = new GridBagConstraints();
        endTurnButtonConstraints.fill = GridBagConstraints.BOTH;
        endTurnButtonConstraints.weighty = 1.0;
        endTurnButtonConstraints.insets = new Insets(5,5,5,5);
        endTurnButtonConstraints.gridx = 0;
        endTurnButtonConstraints.gridy = 4;
        endTurnButtonConstraints.gridwidth = 2;
        endTurnButtonConstraints.gridheight = 1;

        GridBagConstraints ammunitionConstraints = new GridBagConstraints();
        ammunitionConstraints.fill = GridBagConstraints.BOTH;
        ammunitionConstraints.weighty = 1.0;
        ammunitionConstraints.weightx = 1.0;
        ammunitionConstraints.insets = new Insets(5,5,5,5);
        ammunitionConstraints.gridx = 0;
        ammunitionConstraints.gridy = 5;
        ammunitionConstraints.gridwidth = 1;
        ammunitionConstraints.gridheight = 2;

        GridBagConstraints vehicleConstraints = new GridBagConstraints();
        vehicleConstraints.fill = GridBagConstraints.BOTH;
        vehicleConstraints.weighty = 1.0;
        vehicleConstraints.weightx = 1.0;
        vehicleConstraints.insets = new Insets(5,5,5,5);
        vehicleConstraints.gridx = 1;
        vehicleConstraints.gridy = 5;
        vehicleConstraints.gridwidth = 1;
        vehicleConstraints.gridheight = 2;

        JButton showTabletButton = new JButton("show Tablet");
        showTabletButton.setPreferredSize(new Dimension(50,25));
        JButton generateButton = new JButton("Generate template");
        generateButton.setPreferredSize(new Dimension(50,25));
        JButton cleanButton = new JButton("Clean Up");
        cleanButton.setPreferredSize(new Dimension(50,25));
        JButton spyButton = new JButton("spy");
        JButton diplomacyButton = new JButton("diplomacy");
        JButton throwDiceButton = new JButton("throw dice");
        JButton fightButton = new JButton("fight");
        JButton endTurnButton = new JButton("end turn");
        JPanel ammunitionPanel = new JPanel();
        ammunitionPanel.setBackground(Color.orange);
        ammunitionPanel.setPreferredSize(new Dimension(50,75));
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setBackground(Color.orange);
        vehiclePanel.setPreferredSize(new Dimension(50,75));

        JPanel buttonPanel = new JPanel();

        JPanel playGroundPanel = new JPanel();

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
        buttonPanel.setLayout(menuButtonGridBagLayout);
        buttonPanel.add(generateButton,generateButtonConstraints);
        buttonPanel.add(cleanButton,cleanButtonConstraints);
        buttonPanel.add(showTabletButton,showButtonConstraints);

        buttonPanel.add(spyButton,spyButtonConstraints);
        buttonPanel.add(diplomacyButton,diplomacyButtonConstraints);

        buttonPanel.add(throwDiceButton,throwDiceButtonConstraints);
        buttonPanel.add(fightButton,fightButtonConstraints);
        buttonPanel.add(endTurnButton,endTurnButtonConstraints);

        buttonPanel.add(ammunitionPanel,ammunitionConstraints);
        buttonPanel.add(vehiclePanel,vehicleConstraints);

        playGroundPanel.add(playGroundPainter);
        playGroundPanel.setSize(playGroundPainter.getSize());
        playGroundPanel.setBackground(Color.black);

        contentPane.setLayout(gridBagLayout);
        contentPane.add(playGroundPanel,constraintsPlayGround);
        contentPane.setBackground(Color.gray);

        contentPane.add(buttonPanel,constraintsButtonPanel);

    }
}
