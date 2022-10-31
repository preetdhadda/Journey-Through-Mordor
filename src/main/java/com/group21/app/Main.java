package com.group21.app;

import javax.swing.*;

import com.group21.app.Screen.MenuPanel;
import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.TitlePanel;

import java.awt.*;

public class Main {

    public static void makeTitleWindow(){
        // create window with JFrame
        JFrame window = new JFrame("Title Window");
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

    public static void main(String[] args) {
        makeTitleWindow();
    }
}

// COMPILE THE CODE: mvn package
// RUNNING THE CODE: java -cp target/Phase-2-1.0.jar com.group21.app.Main