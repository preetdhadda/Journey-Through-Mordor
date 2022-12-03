package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.group21.app.Screen.Buttons;

/**
 * This class creates the images and and buttons 
 * for TitlePanel
 * 
 * @author Jimmy
 */
public class TitlePanel extends JPanel implements ActionListener {

    UI ui = UI.getInstance();
    public JButton playBTN;

    /**
     * The constructor sets up the window with the play game button and 
     * sets dimension and layout of images
     * 
     * @author Jimmy
     */
    public TitlePanel(){
        // Set size of screen
        setPreferredSize(new Dimension(1350, 675));

        // Set state of game
        UI.gameState = "titlePanel";
    
        // create JButton for playBTN
        playBTN = new Buttons("playGame",460,350,400,70).getBTN();
        setLayout(null);

        // Add playBTN
        add(playBTN);
        playBTN.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                // Go to game window if playBTN is pressed
                ui.makeRuleWindow();
                JComponent comp = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(comp);
                window.dispose();
            }
        });

    }
    
    /** 
     * Paints the background image and game title
     * onto the panel
     * 
     * @param graphic instance of Graphics to diplay on the screen
     * @author Jimmy
     */
    @Override
    public void paintComponent(Graphics graphic) {

        Image background = new ImageIcon("src/main/resources/images/mordor.png").getImage();
        Image gameTitle = new ImageIcon("src/main/resources/images/gameTitle.png").getImage();

        super.paintComponent(graphic);
        
        // Paint the background and game title
        graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
        graphic.drawImage(gameTitle,250,250,800,100,null);
    }

    /**
     * This method's override is required in order to implement ActionListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Jimmy
     */
    @Override
    public void actionPerformed(ActionEvent e) {}
}
