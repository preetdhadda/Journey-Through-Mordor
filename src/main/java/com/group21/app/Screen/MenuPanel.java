package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class MenuPanel extends JPanel implements ActionListener {
    public int score = 0;
    private int second = 0;
    private int minute = 0;

    // following "decimal" attributes are so the timer is in the format 00:00 rather than 0:0
    private String decimalSecond;
    private String decimalMinute;
    DecimalFormat decimal = new DecimalFormat("00");
    private Timer timer;

    // JLabels to display score and time
    JLabel scoreLabel;
    JLabel timeLabel;

    Font myFont = new Font("Serif", Font.PLAIN, 24);

    public MenuPanel() {
        // panel settings
        setPreferredSize(new Dimension(1350, 90));
        setBackground(new Color(128, 128, 128));

        // create JLabel to display the score
        scoreLabel = new JLabel("   Score: " + score + "    |    ");
        scoreLabel.setFont(myFont);
        scoreLabel.setForeground(Color.BLACK);

        // create JLabel to display the time
        timeLabel = new JLabel("Time Elapsed: 00:00");
        timeLabel.setFont(myFont);
        timeLabel.setForeground(Color.BLACK);

        // create JButton for stop
        JButton stop = new JButton(new ImageIcon("src/main/resources/images/stop.png"));
        stop.setFocusable(false); // to prevent button from taking focus in window
        stop.setBackground(new Color(128, 128, 128));
        stop.setOpaque(true);
        stop.setBorderPainted(false);

        // create JButton for play/pause
        JButton playPause = new JButton(new ImageIcon("src/main/resources/images/play_pause.png"));
        playPause.setFocusable(false); // to prevent button from taking focus in window
        playPause.setBackground(new Color(128, 128, 128));
        playPause.setOpaque(true);
        playPause.setBorderPainted(false);

        // create JLabel's for sword images
        JLabel stingLeft = new JLabel(new ImageIcon("src/main/resources/images/stingLeft.png"));
        JLabel stingRight = new JLabel(new ImageIcon("src/main/resources/images/stingRight.png"));

        // ADD LABELS AND BUTTONS TO PANEL (IN ORDER AS SEEN):
        // left sword
        add(stingLeft);

        // stop button
        add(stop);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // play/pause button
        add(playPause);
        playPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("playing/pausing game");
            }
        });

        // score and time labels
        add(scoreLabel);
        add(timeLabel);
        // right sword
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

                // if seconds hits 60, reset to 0 and increment minutes
                if (second == 60) {
                    second = 0;
                    minute++;
                    decimalSecond = decimal.format(second);
                    decimalMinute = decimal.format(minute);

                    timeLabel.setText("Time Elapsed: " + decimalMinute + ":" + decimalSecond);
                }
            }
        });
    }

    // won't be implementing this
    @Override
    public void actionPerformed(ActionEvent e) {}
}
