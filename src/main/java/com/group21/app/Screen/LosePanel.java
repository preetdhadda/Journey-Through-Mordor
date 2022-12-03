package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.group21.app.Entity.Character;
import com.group21.app.Entity.Enemy;

/**
 * This class instantiates the lose panel and positions
 * all the images in it
 * 
 * @author Jimmy
 */
public class LosePanel extends JPanel implements ActionListener {

    UI ui = UI.getInstance();
    String state;
    public JButton replayBTN;
    
    /**
     * The constructor creates the buttons on the lose panel
     * that connect back to the game window
     * @param state string defining the reason for losing
     * @author Jimmy 
     */
    public LosePanel(String state){
        setPreferredSize(new Dimension(1350, 675));
        this.state = state;

        // Set state of game
        UI.gameState = "losePanel";

        replayBTN =  new Buttons("playAgain", 460, 460, 400, 70).getBTN();
        add(replayBTN);
        
        setLayout(null);

        replayBTN.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

                // Go to game window if playBTN is pressed
                Enemy.playerFound = true;
                ui.makeGameWindow();

                JComponent comp = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(comp);
                window.dispose();
            }
        });
    }
    
    /** 
     * Paints the different types of lose panel
     * depending on how the character lost
     * 
     * @param graphic instance of Graphics to display on screen
     * @author Jimmy
     */
    @Override
    public void paintComponent(Graphics graphic) {

        if (state == "rewards"){
            Image background = new ImageIcon("src/main/resources/images/loseScreen1.png").getImage();
            super.paintComponent(graphic);
            
            // Paint the background and game title
            graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
        }
        else if (state == "score"){
            Image background = new ImageIcon("src/main/resources/images/loseScreen2.png").getImage();
            super.paintComponent(graphic);
            
            // Paint the background and game title
            graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
            Character.score = 0;
        }   
        else if (state == "enemy"){
            Image background = new ImageIcon("src/main/resources/images/loseScreen3.png").getImage();
            super.paintComponent(graphic);
            
            // Paint the background and game title
            graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
        }
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
