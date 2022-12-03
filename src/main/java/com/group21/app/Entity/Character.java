package com.group21.app.Entity;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class creates an entity for the game's main character (Frodo).
 * <p>
 * This class handles the rendering of the character on the screen, as well
 * as its movement across the screen according to user input.
 */
public class Character extends Entity implements KeyListener {
    // main character attributes
    static Character singletonInstance = null;
    private Image characterLeftImage;
    private Image characterRightImage;
    public static int score = 0;
    public static int rewardsCollected = 0;
    private String imageDirection;
    private boolean keyDownFlag = false;
    ScreenPanel screen;

    /**
     * This constructor loads character's image and sets its initial position and direction on the screen.
     *
     * @param screen instance of ScreenPanel in which to load Frodo's image
     * @see ScreenPanel
     * @author Preet
     */
    public Character(ScreenPanel screen, String imgD) {
        loadImage();
        position = new Point(1,1);
        this.screen = screen;
        this.imageDirection = imgD;
    }

    /**
     * Use the singleton design pattern to only allow
     * for one instance of Character to exist
     *
     * @return Character
     * @author Preet
     */
    public static Character getInstance(ScreenPanel screen, String imgD){
        if (singletonInstance == null){
            return singletonInstance = new Character(screen, imgD);
        }
        else{
            return singletonInstance;
        }
    }

    /**
     * Resets every static object in Character by
     * setting it to null
     *
     * @author Preet
     */
    public static void deleteInstance() {
        singletonInstance = null;
    }

    /**
     * This method loads the left and right images for character.
     * In later methods, the left and right images will be rendered according to which direction
     * character is moving in.
     * <p>
     * This method creates instances of ImageIcon from the javax.swing library.
     *
     * @author Preet
     */
    private void loadImage () {
        characterLeftImage = new ImageIcon("src/main/resources/images/frodo_left.png").getImage();
        characterRightImage = new ImageIcon("src/main/resources/images/frodo_right.png").getImage();
    }

    /**
     * This method draws character's images onto the ScreenPanel.
     * <p>
     * Checks to see which direction the character is facing, then chooses the image facing that direction.
     * Uses drawImage() from the java.awt library to render the image onto the screen.
     *
     * @param graphic an instance of Graphics from java.awt, which allows rendering of images onto screen
     * @author Preet
     */
    public void draw(Graphics graphic) {
        Image img = null;

        switch(imageDirection) {
            case "left":
                img = characterLeftImage;
                break;
            case "right":
                img = characterRightImage;
                break;
        }

        graphic.drawImage(img, position.x* ScreenPanel.cellSize, position.y* ScreenPanel.cellSize, null);
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
     * <p>
     * Takes keyboard input on arrow keys and checks the direction of the character. Then checks to see if the
     * adjacent cell can be entered by character. If no collision is detected, character's position is translated by
     * one cell and redrawn on the screen in actionPerformed() in the ScreenPanel class.
     *
     * @param e the event to be processed
     * @see ScreenPanel
     * @see detectCollision
     * @author Preet
     * @author Jimmy
     */
    @Override
    public void keyPressed(KeyEvent e) {
        
        if (keyDownFlag == false){

            int key = e.getKeyCode();

            if(key == KeyEvent.VK_UP) {
                direction = "up";
            }
            if(key == KeyEvent.VK_DOWN) {
                direction = "down";
            }
            if(key == KeyEvent.VK_LEFT) {
                direction = "left";
                imageDirection = "left";
            }
            if(key == KeyEvent.VK_RIGHT) {
                direction = "right";
                imageDirection = "right";
            }
            
            collisionOn = false;
            // Check if that cell can be entered
            screen.collisionChecker.checkCell(this);
            
            // If collision is false (no obstacles) then the character can move
            if (collisionOn == false){
                switch(direction){
                    case "up":
                        position.translate(0, -1);
                        break;
                    case "down":
                        position.translate(0, 1);
                        break;
                    case "left":
                        position.translate(-1, 0);
                        break;
                    case "right":
                        position.translate(1, 0);
                        break;
                }
            }
        }
        keyDownFlag = true;
    }

    /**
     * Override keyReleased in KeyListener to prevent the user from holding down arrow keys
     * and having character run across screen.
     *
     * @param e the event to be processed
     * @author Jimmy
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyDownFlag = false;
    }
}
