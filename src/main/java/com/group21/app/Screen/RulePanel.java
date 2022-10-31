package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RulePanel extends JPanel implements ActionListener,KeyListener {

    public RulePanel(JFrame window){
        // Set size of screen
        setPreferredSize(new Dimension(1350, 675));

        // create JButton for playBTN
        JButton playBTN = new JButton(new ImageIcon("src/main/resources/images/playGame.png"));
        playBTN.setFocusable(false); // to prevent button from taking focus in window
        playBTN.setOpaque(true);
        playBTN.setBorderPainted(true);
        playBTN.setBounds(460,590, 400,70);
        setLayout(null);

        // Add playBTN
        add(playBTN);
        playBTN.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                // Go to game window if playBTN is pressed
                makeGameWindow();
                JComponent comp = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(comp);
                window.dispose();
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics graphic) {

        Image background = new ImageIcon("src/main/resources/images/ruleScreen.png").getImage();
        super.paintComponent(graphic);
        graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
    }

    // Calling the inGame window
    public static void makeGameWindow() {
        // create window with JFrame
        JFrame window = new JFrame("Journey Through Mordor");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);

        // instantiate screen and menu panels
        ScreenPanel screenPanel = new ScreenPanel();
        MenuPanel menuPanel = new MenuPanel(screenPanel);

        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));

        // add screen and score to the container
        gameContainer.add(screenPanel);
        window.addKeyListener(screenPanel);
        gameContainer.add(menuPanel);
        window.pack(); // makes window fit preferred size of screen

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    // won't be implementing this
    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
