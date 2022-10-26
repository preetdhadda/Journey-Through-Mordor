package com.group21.app.Screen;

import com.group21.app.Cell.CellMap;
import com.group21.app.Entity.Character;
import com.group21.app.Entity.detectCollision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements ActionListener, KeyListener {
    // attributes for turning screen into a grid of cells
    public static int cellSize = 45;
    public final int numColumns = 30;
    public final int numRows = 15;

    // instantiate main character
    private Character character;

    public CellMap cellM = new CellMap(this);

    // timer attributes
    Timer timer;
    private int delay = 100; // in milliseconds

    // Collision Detection
    public detectCollision collisionChecker = new detectCollision(this);

    // screen constructor
    public Screen() {
        // set size of game screen
        setPreferredSize(new Dimension(cellSize*numColumns, cellSize*numRows));

        // render main character
        character = new Character(this);

        // timer for controlling delay between moving ticks
        timer = new Timer(delay, this);
        timer.start();

    }

    // override paintComponent() in JComponent
    public void paintComponent(Graphics graphic) {
        // render the main character on the screen by calling draw in character
        cellM.draw(graphic);
        character.draw(graphic);

    }

    // called in timer method, redraws the character after its been moved
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // this will recall paintComponent to redraw the character
    }

    // the following 3 key listener methods are overridden in the character class
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        character.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
