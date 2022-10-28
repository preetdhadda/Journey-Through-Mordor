package com.group21.app;

import javax.swing.*;

import com.group21.app.Screen.MenuPanel;
import com.group21.app.Screen.ScreenPanel;

import java.awt.*;

public class Main {
    public static void makeWindow() {
        // create window with JFrame
        JFrame window = new JFrame("Journey Through Mordor");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);

        // instantiate screen and menu panels
        ScreenPanel screenPanel = new ScreenPanel();
        MenuPanel menuPanel = new MenuPanel();

        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));

        // add screen and score to the container
        gameContainer.add(screenPanel);
        window.addKeyListener(screenPanel);
        gameContainer.add(menuPanel);
        window.pack(); // makes window fit preferred size of screen

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    public static void main(String[] args) {
        makeWindow();
    }
}

// COMPILE THE CODE: mvn package
// RUNNING THE CODE: java -cp target/Phase-2-1.0.jar com.group21.app.Main