package com.group21.app.Screen;

import com.group21.app.Cell.CellMap;
import com.group21.app.Entity.Bonus;
import com.group21.app.Entity.Character;
import com.group21.app.Entity.Enemy;
import com.group21.app.Entity.Reward;
import com.group21.app.Entity.detectCollision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ScreenPanel extends JPanel implements ActionListener, KeyListener {
    // attributes for turning screen into a grid of cells
    public static int cellSize = 45;
    public final int numColumns = 30;
    public final int numRows = 15;

    // instantiate main character
    public static Character character;

    public CellMap cellM = new CellMap(this);

    // instantitate rewarads and bonuses
    public Reward bow = new Reward(this, 8, cellM.map, 13, 1);

    public Reward bread1 = new Reward(this, 9, cellM.map, 7, 1);
    public Reward bread2 = new Reward(this, 9, cellM.map, 4, 3);
    public Reward bread3 = new Reward(this, 9, cellM.map, 8, 7);
    public Reward bread4 = new Reward(this, 9, cellM.map, 7, 11);
    public Reward bread5 = new Reward(this, 9, cellM.map, 13, 13);
    public Reward bread6 = new Reward(this, 9, cellM.map, 10, 14);
    public Reward bread7 = new Reward(this, 9, cellM.map, 2, 19);
    public Reward bread8 = new Reward(this, 9, cellM.map, 9, 24);
    public Reward bread9 = new Reward(this, 9, cellM.map, 6, 26);

    public Reward dagger = new Reward(this, 10, cellM.map, 4, 28);

    public Reward spear = new Reward(this, 11, cellM.map, 1, 13);

    public Reward water1 = new Reward(this, 12, cellM.map, 1, 4);
    public Reward water2 = new Reward(this, 12, cellM.map, 6, 5);
    public Reward water3 = new Reward(this, 12, cellM.map, 13, 6);
    public Reward water4 = new Reward(this, 12, cellM.map, 7, 14);
    public Reward water5 = new Reward(this, 12, cellM.map, 10, 16);
    public Reward water6 = new Reward(this, 12, cellM.map, 8, 21);
    public Reward water7 = new Reward(this, 12, cellM.map, 11, 26);
    public Reward water8 = new Reward(this, 12, cellM.map, 8, 27);

    public Bonus gandalf = new Bonus(this, 13, cellM.map, 6, 23);
    public Bonus sam = new Bonus(this, 14, cellM.map, 13, 8);

    public static Enemy gollum;
    public static Enemy ork;
    public static Enemy shelob;
    public static Enemy witch_king;

    // timer attributes
    public static Timer timer;
    private static int delay = 1000; // in milliseconds

    // Collision Detection
    public detectCollision collisionChecker = new detectCollision(this);

    static ScreenPanel singletonInstance;

    // screen constructor
    private ScreenPanel() {
        // set size of game screen
        setPreferredSize(new Dimension(cellSize * numColumns, cellSize * numRows));

        setBackground(new Color(54,54,54));

        // render main character
        character = null;
        ork = null;
        shelob = null;
        witch_king = null;
        gollum = null;
        
        character = new Character(this);

        // render enemies
        ork = new Enemy(this,"orc",1,13,15,cellM.map);
        shelob = new Enemy(this,"shelob",6, 4,16,cellM.map);
        witch_king = new Enemy(this,"witch_king",26, 2, 18, cellM.map);
        gollum = new Enemy(this, "gollum", 24, 11, 19, cellM.map);
        
        timer = null;
        timer = new Timer(delay, this);
        timer.start();
    }

    public static ScreenPanel getInstance(){
        if (singletonInstance == null){
            return singletonInstance = new ScreenPanel();
        }
        else{
            return singletonInstance;
        }
    }

    public static void deleteInstance(){
        timer = null;
        character = null;
        ork = null;
        shelob = null;
        witch_king = null;
        gollum = null;
        singletonInstance = null;
    }


    // override paintComponent() in JComponent
    public void paintComponent(Graphics graphic) {
        // render the main character on the screen by calling draw in character
        cellM.draw(graphic);
        character.draw(graphic);
        ork.draw(graphic);
        shelob.draw(graphic);
        witch_king.draw(graphic);
        gollum.draw(graphic);
    }

    // called in timer method, redraws the character after its been moved
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(Enemy.playerFound);
        if(Enemy.playerFound == false){
            ork.moveToPlayer(character);
            shelob.moveToPlayer(character);
            witch_king.moveToPlayer(character);
            gollum.moveToPlayer(character);
        }
        repaint(); // this will recall paintComponent to redraw the character
    }

    // the following 3 key listener methods are overridden in the character class
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        character.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        character.keyReleased(e);
    }
}
