package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * This class creates instantiates the rule panel and positions
 * all the images in it
 * 
 * @author Jimmy
 */
public class RulePanel extends JPanel implements ActionListener,KeyListener {

    UI ui = UI.getInstance();
    public static JFrame gameWindow;
    JButton continueBTN;

    /**
     * The constructor creates the images on the rule panel
     * and connects the continue button to the game window
     *
     * @author Jimmy
     */
    public RulePanel(){
        // Set size of screen
        setPreferredSize(new Dimension(1350, 675));

        // Set state of game
        UI.gameState = "rulePanel";

        // create JButton for playBTN
        continueBTN = new Buttons("continue",460,590,400,70).getBTN();
        
        setLayout(null);

        // Add playBTN
        add(continueBTN);
        continueBTN.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                // Go to game window if playBTN is pressed
                ui.makeGameWindow();
                JComponent comp = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(comp);
                window.dispose();
            }
        });
    }
    
    
    /** 
     * Paints the background image onto the rule screen
     * 
     * @param graphic instance of Graphics to display on screen
     * @author Jimmy
     */
    @Override
    public void paintComponent(Graphics graphic) {

        Image background = new ImageIcon("src/main/resources/images/ruleScreen.png").getImage();
        super.paintComponent(graphic);
        graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
    }

    /**
     * This method's override is required in order to implement KeyListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Jimmy
     */
    @Override
    public void keyPressed(KeyEvent e) {}

    /**
     * This method's override is required in order to implement ActionListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Jimmy
     */
    @Override
    public void actionPerformed(ActionEvent e) {}

    /**
     * This method's override is required in order to implement KeyListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Jimmy
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * This method's override is required in order to implement KeyListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Jimmy
     */
    @Override
    public void keyReleased(KeyEvent e) {}
}
