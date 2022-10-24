package com.group21.app;

import javax.swing.*;

public class Main {
    public static void makeWindow() {
        // create window with JFrame
        JFrame window = new JFrame("Journey Through Mordor");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);

        // create a jpanel screen and add the window to it
        Screen screen = new Screen();
        window.add(screen);
        window.addKeyListener(screen);
        window.pack(); // makes window fit preferred size of screen

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window

    }

    public static void main(String[] args) {
        makeWindow();
    }
}
