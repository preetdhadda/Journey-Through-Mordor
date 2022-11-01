package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.group21.app.Entity.Character;
import java.text.DecimalFormat;

public class WinPanel extends JPanel implements ActionListener {

    private int second = 0;
    private int minute = 0;

    // following "decimal" attributes are so the timer is in the format 00:00 rather than 0:0
    private String decimalSecond;
    private String decimalMinute;
    DecimalFormat decimal = new DecimalFormat("00");
    private Timer timer;


    UI ui = UI.getInstance();
    JLabel scoreLabel;
    JLabel timeLabel;

    Font myFont = new Font("Serif", Font.PLAIN, 40);

    public WinPanel(){
        // Set size of screen
        setPreferredSize(new Dimension(1350, 675));

        scoreLabel = new JLabel("   Score: " + Character.score);
        scoreLabel.setFont(myFont);
        scoreLabel.setForeground(Color.YELLOW);
        scoreLabel.setBounds(570,140,400,300);
        add(scoreLabel);
        
        
        
        System.out.println(MenuPanel.decimalMinute);
        System.out.println(MenuPanel.decimalSecond);
        
        timeLabel = new JLabel("Time Elapsed: " + MenuPanel.decimalMinute + ":"+MenuPanel.decimalSecond);
        timeLabel.setFont(myFont);
        timeLabel.setForeground(Color.YELLOW);
        timeLabel.setBounds(500,200,500,300);
        add(timeLabel);


        JButton replayBTN = new JButton(new ImageIcon("src/main/resources/images/playAgain.png"));
        replayBTN.setFocusable(false); // to prevent button from taking focus in window
        replayBTN.setOpaque(true);
        replayBTN.setBorderPainted(true);
        replayBTN.setBounds(460,400, 400,70);
        add(replayBTN);
        
        setLayout(null);

        replayBTN.addActionListener(new ActionListener() {
            
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

    @Override
    public void paintComponent(Graphics graphic) {

        Image background = new ImageIcon("src/main/resources/images/winScreen.png").getImage();
        super.paintComponent(graphic);
        
        // Paint the background and game title
        graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
    }

    // won't be implementing this
    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
