package com.group21.app.Screen;

import javax.swing.*;

import com.group21.app.Entity.Character;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * This class builds a JPanel to create the menu panel below the game screen.
 * It renders the character, rewards, bonuses, and enemies onto the screen.
 * <p>
 * Implements ActionListener from java.awt to allow bonuses to appear and reappear randomly.
 */
public class MenuPanel extends JPanel implements ActionListener {
    ScreenPanel screen;

    public int second = 0;
    public int minute = 0;

    // following "decimal" attributes are so the timer is in the format 00:00 rather than 0:0
    public static String decimalSecond;
    public static String decimalMinute;
    DecimalFormat decimal = new DecimalFormat("00");
    private Timer timer;

    JLabel scoreLabel; // display score
    JLabel timeLabel; // display time

    Font myFont = new Font("Serif", Font.PLAIN, 24);

    /**
     * This constructor builds a JPanel to display the score board.
     * <p>
     * It sets the size of the panel and background colour. It creates JLabels for displaying the score
     * and time attributes and sword images. And it adds the JLabels to the JPanel
     *
     * @param screen instance of ScreenPanel to attach MenuPanel to
     * @see ScreenPanel
     * @author Preet
     */
    public MenuPanel(ScreenPanel screen) {
        this.screen = screen;
        // panel settings
        setPreferredSize(new Dimension(1350, 90));
        setBackground(new Color(128, 128, 128));

        // Set state of game
        UI.gameState = "menupanel";

        // create JLabel to display the score
        scoreLabel = new JLabel("   Score: " + Character.score + "    |    ");
        scoreLabel.setFont(myFont);
        scoreLabel.setForeground(Color.BLACK);

        // create JLabel to display the time
        timeLabel = new JLabel("Time Elapsed: 00:00");
        timeLabel.setFont(myFont);
        timeLabel.setForeground(Color.BLACK);

        // create JLabel's for sword images
        JLabel stingLeft = new JLabel(new ImageIcon("src/main/resources/images/stingLeft.png"));
        JLabel stingRight = new JLabel(new ImageIcon("src/main/resources/images/stingRight.png"));

        add(stingLeft);
        add(scoreLabel);
        add(timeLabel);
        add(stingRight);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // start the timer
        timeElapsed();
        timer.start();
    }

    /**
     * This method uses the Timer object in javax.swing to display a timer on the screen
     * and for facilitating the random appearances/disappearances of the bonuses.
     * <p>
     * Overrides actionPerformed in ActionListener. Uses the DecimalFormat class from java.text
     * to format the on screen timer as 00:00, as opposed to 0:0 if it just used Ints. Manually
     * increments the seconds and minutes displayed in the timer.
     *<p>
     * Additionally, it is used to manage the availability of bonuses
     * For every minute:
     * <p>
     * during the 0-10th second, both bonuses will spawn (if not collected) in their respective positions
     * <p>
     * during the 10-20th second, both bonuses will be inactive
     * <p>
     * during the 20-30th second, Sam will spawn (if not collected) in Gandalf's position
     * <p>
     * during the 30-40th second, both bonuses will be inactive
     * <p>
     * during the 40-50th second, Gandalf will spawn (if not collected) in Sam's position
     * <p>
     * during the 50-60th second, both bonuses will be inactive
     *
     * @author Preet
     * @author Jeffrey
     */
    public void timeElapsed() {
        // update the timer every 1000 milliseconds (1 second)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // convert seconds and minutes to decimals for 00:00 format instead of 0:0
                second++;
                decimalSecond = decimal.format(second);
                decimalMinute = decimal.format(minute);

                timeLabel.setText("Time Elapsed: " + decimalMinute + ":" + decimalSecond);

                if (second == 10) {
                    screen.cellM.map[screen.gandalf.xPos][screen.gandalf.yPos] = 0; 
                    screen.cellM.map[screen.sam.xPos][screen.sam.yPos] = 0;
                }
                if (second == 20) {
                    if (!screen.sam.token) {
                        screen.cellM.map[screen.gandalf.xPos][screen.gandalf.yPos] = 14;
                    }
                }
                if (second == 30) {
                    screen.cellM.map[screen.gandalf.xPos][screen.gandalf.yPos] = 0; 
                }
                if (second == 40) {
                    if (!screen.gandalf.token) {
                        screen.cellM.map[screen.sam.xPos][screen.sam.yPos] = 13; 
                    }
                }
                if (second == 50) {
                    screen.cellM.map[screen.sam.xPos][screen.sam.yPos] = 0;
                }

                // if seconds hits 60, reset to 0 and increment minutes
                if (second == 60) {
                    if (!screen.gandalf.token) {
                        screen.cellM.map[screen.gandalf.xPos][screen.gandalf.yPos] = 13; 
                    }
                    if (!screen.sam.token) {
                        screen.cellM.map[screen.sam.xPos][screen.sam.yPos] = 14;
                    }

                    second = 0;
                    minute++;
                    decimalSecond = decimal.format(second);
                    decimalMinute = decimal.format(minute);

                    timeLabel.setText("Time Elapsed: " + decimalMinute + ":" + decimalSecond);
                }
                // update score, if character collects rewards during tick
                scoreLabel.setText("   Score: " + Character.score + "    |    ");
            }
        });
    }

    /**
     * This method's override is required in order to implement ActionListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Preet
     */
    @Override
    public void actionPerformed(ActionEvent e) {}
}
