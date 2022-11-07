package com.group21.app.Entity;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class creates an entity for the game's moving enemies.
 * <p>
 * This class handles the rendering of the enemies on the screen, as well
 * as its movement across the screen and collision detection.
 */
public class Enemy extends Entity {
    UI ui = UI.getInstance();
    private Image characterLeft;
    private Image characterRight;
    private String imageDirection;
    ScreenPanel screen;
    public static boolean playerFound = false;
    public static ArrayList<Enemy> EnemyArray = new ArrayList<Enemy>();
    String type;

     /**
     * This constructor loads the enemies images and sets its initial position and direction on the screen.
     *
     * @param screen instance of ScreenPanel in which to load enemies image
     * @param type type of enemy that is being passed in
     * @param x,y coordinates where the enemy will start off at
     * @author jsc48
     */
    public Enemy(ScreenPanel screen, String type, int x, int y){
        loadImage(type);
        position = new Point(x,y);
        this.screen = screen;
        imageDirection = "right";
        this.type = type;
    }

    /**
     * This method loads the left and right images for enemy.
     * In later methods, the left and right images will be rendered according to which direction
     * character is moving in.
     * <p>
     * @param type represent the type of enemy we are rendering
     * @author jimmy
     */
    private void loadImage(String type) {
        // load main character's images
        switch(type){
            case "orc":
                characterLeft = new ImageIcon("src/main/resources/images/orc_left.png").getImage();
                characterRight = new ImageIcon("src/main/resources/images/orc_right.png").getImage();         
                break;
            case "shelob":
                characterLeft = new ImageIcon("src/main/resources/images/shelob.png").getImage();
                characterRight = new ImageIcon("src/main/resources/images/shelob.png").getImage();         
                break;   
            case "witch_king":
                characterLeft = new ImageIcon("src/main/resources/images/witch_king_left.png").getImage();
                characterRight = new ImageIcon("src/main/resources/images/witch_king_right.png").getImage();
                imageDirection = "left";
                break;
            case "gollum":
                characterLeft = new ImageIcon("src/main/resources/images/smeagol_left.png").getImage();
                characterRight = new ImageIcon("src/main/resources/images/smeagol_right.png").getImage();
                imageDirection = "left";
                break;
        }
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

        switch (imageDirection) {
            case "left":
                img = characterLeft;
                break;
            case "right":
                img = characterRight;
                break;
        }

        graphic.drawImage(img, position.x * ScreenPanel.cellSize, position.y * ScreenPanel.cellSize, null);
        screen.repaint();
    }

    /**
     * This method determines which x,y coordinate the enemy should move towards inorder to reach the player.
     * If the x coordinate is greater then y, then move in the x direction else move in y direction
     * @param player takes in the user entity
     * @author jsc48
     */
    public void moveToPlayer(Character player) {

        Point enemyCurrentLocation = position;
        Point playersLocation = player.position;

        Point pathToPlayer = new Point((player.position.x - enemyCurrentLocation.x),(playersLocation.y - enemyCurrentLocation.y));

        if (Math.abs((pathToPlayer.x)) > Math.abs((pathToPlayer.y))) {
            if (pathToPlayer.x > 0 && checkCollision(position.x + 1, position.y, player) == false) {
                imageDirection = "right";
                position.translate(1, 0);

            } else if (pathToPlayer.x < 0 && checkCollision(position.x - 1, position.y, player) == false) {
                imageDirection = "left";
                position.translate(-1, 0);
            }
        } else if (Math.abs((pathToPlayer.x)) < Math.abs((pathToPlayer.y))) {
            if (pathToPlayer.y > 0 && checkCollision(position.x, position.y + 1, player) == false) {
                position.translate(0, 1); // Down

            } else if (pathToPlayer.y < 0 && checkCollision(position.x, position.y - 1, player) == false) {
                position.translate(0, -1); // Up

            }
        } else if (Math.abs((pathToPlayer.x)) == Math.abs(0) && (pathToPlayer.y) == Math.abs(0)) {
            playerFound = true;
            ui.makeLoseWindow("enemy");
            ui.disposeGameWindow();
            ScreenPanel.timer.stop();

        } else {
            if (pathToPlayer.y > 0 && checkCollision(position.x, position.y + 1, player) == false) {
                position.translate(0, 1);

            }
            if (pathToPlayer.y < 0 && checkCollision(position.x, position.y - 1, player) == false) {
                position.translate(0, -1);

            }
        }
    }
    /**
     * This method determines if there is an obstacle in the enemies path, and if so do not move into it.
     * Additionally, this method keeps track of all enemies and makes sure they do not enter into the same cell.
     * 
     * @param player takes in the user entity 
     * @author jsc48
     */
    Boolean checkCollision(int xPos, int yPos, Character player) {
        collisionOn = false;

        Point newPos = new Point(xPos, yPos);
        for(int i = 0; i < EnemyArray.size(); i++){
            Point coordinates = EnemyArray.get(i).position;
            if (newPos.equals(coordinates) && newPos.equals(player.position) == false){
                collisionOn = true;
                return collisionOn;
            }
        }

        if (screen.cellM.map[yPos][xPos] == 1     || screen.cellM.map[yPos][xPos] == 2 
           || screen.cellM.map[yPos][xPos] == 3   || screen.cellM.map[yPos][xPos] == 4
           || screen.cellM.map[yPos][xPos] == 5   || screen.cellM.map[yPos][xPos] == 6
           || screen.cellM.map[yPos][xPos] == 7   ||screen.cellM.map[yPos][xPos] == 15 
           || screen.cellM.map[yPos][xPos] == 20  || screen.cellM.map[yPos][xPos] == 21 
           || screen.cellM.map[yPos][xPos] == 22  || screen.cellM.map[yPos][xPos] == 23 
           || screen.cellM.map[yPos][xPos] == 24){
            collisionOn = true;
        }
        return collisionOn;
    }
}