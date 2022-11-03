package com.group21.app.Screen;

import com.group21.app.Entity.Character;
import com.group21.app.Entity.Enemy;

import javax.swing.*;
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

    private int second = 0;
    private int minute = 0;

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
     * @author preetdhadda
     */
    public MenuPanel(ScreenPanel screen) {
        this.screen = screen;
        // panel settings
        setPreferredSize(new Dimension(1350, 90));
        setBackground(new Color(128, 128, 128));

        // create JLabel to display the score
        scoreLabel = new JLabel("   Score: " + screen.character.score + "    |    ");
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

                // when second is on the interval [15,30] or [45,60], bonuses disappear
                // bonuses reappear after these intervals, unless already collected by character
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
                scoreLabel.setText("   Score: " + screen.character.score + "    |    ");
            }
        });
    }

    /**
     * This method's override is required in order to implement ActionListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author preetdhadda
     */
    @Override
    public void actionPerformed(ActionEvent e) {}
}
