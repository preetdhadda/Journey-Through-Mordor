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

/**
 * This class builds a JPanel to create the game board.
 * It renders the character, rewards, bonuses, and enemies onto the screen.
 * <p>
 * Implements ActionListener and KeyListener from java.awt so user interaction with the screen can be read.
 */
public class ScreenPanel extends JPanel implements ActionListener, KeyListener {
    // attributes for turning screen into a grid of cells
    public static int cellSize = 45;
    public final int numColumns = 30;
    public final int numRows = 15;

    // instantiate main character
    public static Character character;
    // instantiate cell map
    public CellMap cellM = new CellMap(this);

    // instantiate rewards and bonuses
    public Reward bow = new Reward(this, 8,13, 1,50);

    public Reward bread1 = new Reward(this, 9,  7, 1,20);
    public Reward bread2 = new Reward(this, 9,  4, 3,20);
    public Reward bread3 = new Reward(this, 9,  8, 7,20);
    public Reward bread4 = new Reward(this, 9,  7, 11,20);
    public Reward bread5 = new Reward(this, 9,  13, 13,20);
    public Reward bread6 = new Reward(this, 9,  10, 14,20);
    public Reward bread7 = new Reward(this, 9,  2, 19,20);
    public Reward bread8 = new Reward(this, 9,  9, 24,20);
    public Reward bread9 = new Reward(this, 9,  6, 26,20);

    public Reward dagger = new Reward(this, 10,  4, 28,50);

    public Reward spear = new Reward(this, 11,  1, 13,50);

    public Reward water1 = new Reward(this, 12,  1, 4,10);
    public Reward water2 = new Reward(this, 12,  6, 5,10);
    public Reward water3 = new Reward(this, 12,  13, 6,10);
    public Reward water4 = new Reward(this, 12,  7, 14,10);
    public Reward water5 = new Reward(this, 12,  10, 16,10);
    public Reward water6 = new Reward(this, 12,  8, 21,10);
    public Reward water7 = new Reward(this, 12,  11, 26,10);
    public Reward water8 = new Reward(this, 12,  8, 27,10);

    public Bonus gandalf = new Bonus(this, 13, 6, 23,100);
    public Bonus sam = new Bonus(this, 14, 13, 8,100);

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

    /**
     * This constructor builds a JPanel to display the game board.
     * <p>
     * It sets the size of the panel and default background colour. It also creates instances of character and
     * enemies to later be drawn on the screen in PaintComponent(). Finally, it creates a timer with javax.Swing
     * to create a delay when moving character between cells.
     *
     * @see Character
     * @see Enemy
     * @author Preet
     * @author Jessy
     */
    private ScreenPanel() {
        setPreferredSize(new Dimension(cellSize * numColumns, cellSize * numRows));

        setBackground(new Color(54,54,54));

        // Set state of game
        UI.gameState = "screenPanel";

        character = null;
        ork = null;
        shelob = null;
        witch_king = null;
        gollum = null;
        
        character = new Character(this,"left");
        ork = new Enemy(this,"orc",1,13);
        shelob = new Enemy(this,"shelob",6, 4);
        witch_king = new Enemy(this,"witch_king",26, 2);
        gollum = new Enemy(this, "gollum", 24, 11);

        Enemy.EnemyArray.add(ork);
        Enemy.EnemyArray.add(shelob);
        Enemy.EnemyArray.add(witch_king);
        Enemy.EnemyArray.add(gollum);
        
        timer = null;
        timer = new Timer(delay, this);
        timer.start();
    }

    
    /** 
     * Use the singleton design pattern to only allow
     * for one instance of ScreenPanel to exist
     * 
     * @return ScreenPanel
     * @author Jimmy
     */
    public static ScreenPanel getInstance(){
        if (singletonInstance == null){
            return singletonInstance = new ScreenPanel();
        }
        else{
            return singletonInstance;
        }
    }

    /**
     * Resets every object in ScreenPanel by 
     * setting it to null
     * 
     * @author Jimmy
     */
    public static void deleteInstance(){
        timer = null;
        character = null;
        ork = null;
        shelob = null;
        witch_king = null;
        gollum = null;
        singletonInstance = null;
    }

    /**
     * Override paintComponent() in JComponent to draw entities to the screen.
     *
     * @param graphic the Graphics object to render
     * @see CellMap
     * @see Character
     * @see Enemy
     * @author Preet
     * @author Jessy
     */
    public void paintComponent(Graphics graphic) {
        cellM.draw(graphic);
        character.draw(graphic);
        ork.draw(graphic);
        shelob.draw(graphic);
        witch_king.draw(graphic);
        gollum.draw(graphic);
    }

    /**
     * Override actionPerformed in ActionEvent to move entities across the board and
     * repaint the screen after each move.
     *
     * @param e the event to be processed
     * @see Enemy
     * @author Jessy
     * @author Preet
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Enemy.playerFound == false && timer != null && character != null 
           && ork != null && shelob != null && witch_king != null 
           && gollum != null && singletonInstance != null){
            ork.moveToPlayer(character);
            shelob.moveToPlayer(character);
            witch_king.moveToPlayer(character);
            gollum.moveToPlayer(character);
        }
        repaint();
    }

    /**
     * This method's override is required in order to implement KeyListener.
     * However, it isn't used in the program, and therefore isn't implemented.
     *
     * @param e the event to be processed
     * @author Preet
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     * Overriding keyPressed in KeyListener to read the user's keyboard input and moves character accordingly.
     * Overridden and implemented in Character.
     *
     * @param e the event to be processed
     * @see Character
     * @author Preet
     */
    @Override
    public void keyPressed(KeyEvent e) {
        character.keyPressed(e);
    }

    /**
     * Override keyReleased in KeyListener to prevent the user from holding down arrow keys.
     * Overridden and implemented in Character.
     *
     * @param e the event to be processed
     * @see Character
     * @author Jimmy
     */
    @Override
    public void keyReleased(KeyEvent e) {
        character.keyReleased(e);
    }
}
