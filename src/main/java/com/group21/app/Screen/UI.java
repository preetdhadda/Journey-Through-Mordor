package com.group21.app.Screen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.group21.app.Entity.Enemy;
import com.group21.app.Screen.RulePanel;
import com.group21.app.Screen.ScreenPanel;

public class UI {

    static UI singletonInstance;

    private UI(){}

    public static UI getInstance(){
        if (singletonInstance == null){
            singletonInstance = new UI();
        }
        return singletonInstance;
    }

    // Title Panel
    public void makeTitleWindow(){
        JFrame window = new JFrame("Title Window");
        // create window with JFrame
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);

        TitlePanel titlePanel = new TitlePanel();

        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));

        gameContainer.add(titlePanel);
        window.pack();

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    // Rule Panel
    public void makeRuleWindow() {
        
        // create window with JFrame
        JFrame window = new JFrame("Rule Window");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);
        
        // instantiate rule panel
        RulePanel rulepanel = new RulePanel(window);

        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));

        gameContainer.add(rulepanel);
        window.addKeyListener(rulepanel);
        window.pack(); // makes window fit preferred size of screen

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    // Game Panel
    
    JFrame gameWindow = new JFrame("Journey Through Mordor");


    public void makeGameWindow() {
        // create window with JFrame
        gameWindow = new JFrame("Journey Through Mordor");

        // when the user exits the window, stop the game
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        gameWindow.setResizable(false);
        

        // instantiate screen and menu panels
        ScreenPanel screenPanel = ScreenPanel.getInstance(); 
        screenPanel.deleteInstance();
        screenPanel = ScreenPanel.getInstance();

        Enemy.playerFound = false;

        MenuPanel menuPanel = new MenuPanel(screenPanel);
        
        
        // create container for panels
        Container gameContainer = gameWindow.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
        
        // add screen and score to the container
        gameContainer.add(screenPanel);
        gameWindow.addKeyListener(screenPanel);
        gameContainer.add(menuPanel);
        gameWindow.pack(); // makes window fit preferred size of screen
        
        // more window settings
        gameWindow.setLocationRelativeTo(null); // open window in middle of user's device
        gameWindow.setVisible(true);
    }

    public void disposeGameWindow(){
        gameWindow.dispose();
    }

    // Win Panel
    public void makeWinWindow(){
        // create window with JFrame
        JFrame window = new JFrame("Win Window");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);
        
        // instantiate win panel
        WinPanel winpanel = new WinPanel();
    
        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
    
        gameContainer.add(winpanel);
        window.pack(); // makes window fit preferred size of screen
    
        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    public void makeLoseWindow(String state){
        // create window with JFrame
        JFrame window = new JFrame("Lose Window");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);
        
        // instantiate win panel
        LosePanel losepanel = new LosePanel(state);
    
        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
    
        gameContainer.add(losepanel);
        window.pack(); // makes window fit preferred size of screen
    
        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }
    
}


/*
 * 
 * 
 * javax.swing.JFrame[frame0,0,25,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=Journey Through Mordor,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]
 */