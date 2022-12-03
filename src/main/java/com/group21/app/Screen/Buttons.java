package com.group21.app.Screen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class instantiates a JButton
 * and adds attributes such as setFocusable, setOpaque,
 * setBorderPainted, and setBounds
 * 
 * @author Jimmy
 */
public class Buttons extends JPanel {

    public JButton BTN;
    
    /**
     * The constructor initializes the JButton attributes and properties
     * @param type
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Buttons(String type,int x,int y,int width,int height){
        BTN = new JButton(new ImageIcon("src/main/resources/images/"+type+".png"));
        BTN.setFocusable(false);
        BTN.setOpaque(true);
        BTN.setBorderPainted(true);
        BTN.setBounds(x,y,width,height);
    }

    /**
     * Returns an instance of BTN
     * @return
     */
    public JButton getBTN(){
        return BTN;
    }
}


