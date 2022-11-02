package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.group21.app.Entity.Character;
import com.group21.app.Entity.Enemy;

import java.text.DecimalFormat;

public class LosePanel extends JPanel implements ActionListener {

    UI ui = UI.getInstance();
    String state;

    public LosePanel(String state){
        setPreferredSize(new Dimension(1350, 675));
        this.state = state;

        JButton replayBTN = new JButton(new ImageIcon("src/main/resources/images/playAgain.png"));
        replayBTN.setFocusable(false); // to prevent button from taking focus in window
        replayBTN.setOpaque(true);
        replayBTN.setBorderPainted(true);
        replayBTN.setBounds(460,500, 400,70);
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

    // won't be implementing this
    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
