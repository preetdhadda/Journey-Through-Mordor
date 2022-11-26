package com.group21.app;
import com.group21.app.Screen.UI;
import com.group21.app.Entity.Music;

import javax.swing.*;


public class Main {

    /**
     * Main method runs the game.
     * Creates an instance of UI and runs it with the Runnable interface and
     * plays the background music.
     *
     * @param args
     */
    public static void main(String[] args) {
        UI ui = UI.getInstance();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ui.makeTitleWindow();
            }
        });
        Music.setMusic("src/main/resources/music/airtone_-_brokencloud_1.wav");
    }
}

// Music brokencloud by airtone (c) copyright 2022 Licensed under a Creative Commons Attribution Noncommercial  (3.0) license. http://dig.ccmixter.org/files/airtone/65484 
