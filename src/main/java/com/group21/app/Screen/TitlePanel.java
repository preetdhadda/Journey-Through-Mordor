package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitlePanel extends JPanel implements ActionListener {

    UI ui = UI.getInstance();

    public TitlePanel(){
        // Set size of screen
        setPreferredSize(new Dimension(1350, 675));
    
        // create JButton for playBTN
        JButton playBTN = new JButton(new ImageIcon("src/main/resources/images/playGame.png"));
        playBTN.setFocusable(false); // to prevent button from taking focus in window
        playBTN.setOpaque(true);
        playBTN.setBorderPainted(true);
        playBTN.setBounds(460,350, 400,70);
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
    
    @Override
    public void paintComponent(Graphics graphic) {

        Image background = new ImageIcon("src/main/resources/images/mordor.png").getImage();
        Image gameTitle = new ImageIcon("src/main/resources/images/gameTitle.png").getImage();

        super.paintComponent(graphic);
        
        // Paint the background and game title
        graphic.drawImage(background,0, 0, this.getWidth(), this.getHeight(), null);
        graphic.drawImage(gameTitle,250,250,800,100,null);
    }

    // won't be implementing this
    @Override
    public void actionPerformed(ActionEvent e) {}
}
