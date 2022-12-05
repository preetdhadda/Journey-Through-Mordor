package com.group21.app.Entity;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class creates an entity for the game's moving enemies.
 * <p>
 * This class handles the rendering of the enemies on the screen, as well
 * as its movement across the screen and collision detection.
 */
public class Enemy extends Entity {
    UI ui = UI.getInstance();
    private Image characterLeftImage;
    private Image characterRightImage;
    protected String imageFacingDirection = "right";
    ScreenPanel screen;
    public static boolean playerFound = false;
    public static ArrayList<Enemy> EnemyArray = new ArrayList<Enemy>();
    String enemyType;

    /**
     * This constructor loads the enemies images and sets its initial position and
     * direction on the screen.
     *
     * @param screen    instance of ScreenPanel in which to load enemies image
     * @param enemyType enemyType of enemy that is being passed in
     * @param x         x coordinate where the enemy will start off at
     * @param y         y coordinate where the enemy will start off at
     * @author Jessy
     */
    public Enemy(ScreenPanel screen, String enemyType, int x, int y) {
        loadImage(enemyType);
        position = new Point(x, y);
        this.screen = screen;
        this.enemyType = enemyType;
    }

    /**
     * This method loads the left and right images for enemy.
     * In later methods, the left and right images will be rendered according to
     * which direction
     * character is moving in.
     * <p>
     * 
     * @param enemyType represent the enemyType of enemy we are rendering
     * @author Jimmy
     */
    private void loadImage(String enemyType) {
        // load main character's images
        switch (enemyType) {
            case "orc":
                characterLeftImage = new ImageIcon("src/main/resources/images/orc_left.png").getImage();
                characterRightImage = new ImageIcon("src/main/resources/images/orc_right.png").getImage();
                break;
            case "shelob":
                characterLeftImage = new ImageIcon("src/main/resources/images/shelob.png").getImage();
                characterRightImage = new ImageIcon("src/main/resources/images/shelob.png").getImage();
                break;
            case "witch_king":
                characterLeftImage = new ImageIcon("src/main/resources/images/witch_king_left.png").getImage();
                characterRightImage = new ImageIcon("src/main/resources/images/witch_king_right.png").getImage();
                imageFacingDirection = "left";
                break;
            case "gollum":
                characterLeftImage = new ImageIcon("src/main/resources/images/smeagol_left.png").getImage();
                characterRightImage = new ImageIcon("src/main/resources/images/smeagol_right.png").getImage();
                imageFacingDirection = "left";
                break;
        }
    }

    /**
     * This method draws character's images onto the ScreenPanel.
     * <p>
     * Checks to see which direction the character is facing, then chooses the image
     * facing that direction.
     * Uses drawImage() from the java.awt library to render the image onto the
     * screen.
     *
     * @param graphic an instance of Graphics from java.awt, which allows rendering
     *                of images onto screen
     * @author Preet
     */
    public void draw(Graphics graphic) {
        Image img = null;

        switch (imageFacingDirection) {
            case "left":
                img = characterLeftImage;
                break;
            case "right":
                img = characterRightImage;
                break;
        }

        graphic.drawImage(img, position.x * ScreenPanel.cellSize, position.y * ScreenPanel.cellSize, null);
        screen.repaint();
    }

    /**
     * This method determines which x,y coordinate the enemy should move towards
     * inorder to reach the player.
     * If the x coordinate is greater then y, then move in the x direction else move
     * in y direction
     * 
     * @param player takes in the user entity
     * @author Jessy
     */
    public void moveToPlayer(Character player) {

        Point enemyCurrentLocation = position;
        Point playersLocation = player.position;

        Point pathToPlayer = new Point((player.position.x - enemyCurrentLocation.x),
                (playersLocation.y - enemyCurrentLocation.y));

        if (Math.abs((pathToPlayer.x)) > Math.abs((pathToPlayer.y))) {

            translateLeftRight(pathToPlayer, player);

        } else if (Math.abs((pathToPlayer.x)) < Math.abs((pathToPlayer.y))) {

            translateUpDown(pathToPlayer, player);

        } else if (Math.abs((pathToPlayer.x)) == Math.abs(0) && (pathToPlayer.y) == Math.abs(0)) {

            playerIsFound();

        } else {

            translateUpDownWhenPlayerDiagonal(pathToPlayer, player);
        }
    }

    void translateLeftRight(Point pathToPlayer, Character player) {
        if (pathToPlayer.x > 0 && checkCollision(position.x + 1, position.y, player) == false) {
            imageFacingDirection = "right";
            position.translate(1, 0);

        } else if (pathToPlayer.x < 0 && checkCollision(position.x - 1, position.y, player) == false) {
            imageFacingDirection = "left";
            position.translate(-1, 0);
        }
    }

    void translateUpDown(Point pathToPlayer, Character player) {
        if (pathToPlayer.y > 0 && checkCollision(position.x, position.y + 1, player) == false) {
            position.translate(0, 1); // Down

        } else if (pathToPlayer.y < 0 && checkCollision(position.x, position.y - 1, player) == false) {
            position.translate(0, -1); // Up

        }
    }

    void translateUpDownWhenPlayerDiagonal(Point pathToPlayer, Character player){
        if (pathToPlayer.y > 0 && checkCollision(position.x, position.y + 1, player) == false) {
            position.translate(0, 1);

        }
        if (pathToPlayer.y < 0 && checkCollision(position.x, position.y - 1, player) == false) {
            position.translate(0, -1);

        }
    }

    void playerIsFound(){
        playerFound = true;
        Character.deleteInstance();
        ui.makeLoseWindow("enemy");
        ui.disposeGameWindow();
        ScreenPanel.timer.stop();
    }

    /**
     * This method determines if there is an obstacle in the enemies path, and if so
     * do not move into it.
     * Additionally, this method keeps track of all enemies and makes sure they do
     * not enter into the same cell.
     *
     * @return true/false checking if enemy collided with something
     * @param player takes in the user entity
     * @author Jessy
     */
    Boolean checkCollision(int xPos, int yPos, Character player) {
        collisionOn = false;

        // Check if new Position is enemy position
        Point newPos = new Point(xPos, yPos);
        for (int i = 0; i < EnemyArray.size(); i++) {
            Point coordinates = EnemyArray.get(i).position;
            if (newPos.equals(coordinates) && newPos.equals(player.position) == false) {
                collisionOn = true;
                return collisionOn;
            }
        }

        return checkObjectCollision(xPos, yPos);
    }

    /**
     * This method determines if there is an obstacle in the enemies path, and if so
     * do not move into it.
     * Additionally, this method keeps track of all enemies and makes sure they do
     * not enter into the same cell.
     *
     * @return true/false checking if enemy collided with something
     * @param xPos new xPosition enemy moving to
     * @param yPos new yPosition enemy moving to
     * @author Jessy
     */
    public Boolean checkObjectCollision(int xPos, int yPos) {
        int[] cell_id = {1,2,3,4,5,6,7,15,19,20,21,22,23};

        for(int i=0; i < cell_id.length; i++) {
            if (screen.cellM.map[yPos][xPos] == cell_id[i]) {
                collisionOn = true;
            }
         }
        return collisionOn;
    }
}