package com.group21.app.Entity;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

import java.awt.*;

public class Enemy extends Entity {
    UI ui = UI.getInstance();
    private Image characterLeft;
    private Image characterRight;
    private String imageDirection;
    ScreenPanel screen;
    public static boolean playerFound = false;
    private int id;
    String type;

    public Enemy(ScreenPanel screen, String type, int x, int y, int id, int[][] map){
        loadImage(type);
        position = new Point(x,y);
        this.screen = screen;
        imageDirection = "right";
        this.type = type;
    }

    // load image method
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

    // draw image method
    // checks the direction of the character and draws the appropriate image
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

    public void moveToPlayer(Character player) {

        Point enemyCurrentLocation = position;
        Point playersLocation = player.position;

        Point pathToPlayer = new Point((player.position.x - enemyCurrentLocation.x),
                (playersLocation.y - enemyCurrentLocation.y));

        if (Math.abs((pathToPlayer.x)) > Math.abs((pathToPlayer.y))) {
            if (pathToPlayer.x > 0 && checkCollision(position.x + 1, position.y) == false) {
                imageDirection = "right";
                position.translate(1, 0);

            } else if (pathToPlayer.x < 0 && checkCollision(position.x - 1, position.y) == false) {
                imageDirection = "left";
                position.translate(-1, 0);
            }
        } else if (Math.abs((pathToPlayer.x)) < Math.abs((pathToPlayer.y))) {
            if (pathToPlayer.y > 0 && checkCollision(position.x, position.y + 1) == false) {
                position.translate(0, 1); // Down

            } else if (pathToPlayer.y < 0 && checkCollision(position.x, position.y - 1) == false) {
                position.translate(0, -1); // Up

            }
        } else if (Math.abs((pathToPlayer.x)) == Math.abs(0) && (pathToPlayer.y) == Math.abs(0)) {
            playerFound = true;
            ui.makeLoseWindow("enemy");
            ui.disposeGameWindow();
            ScreenPanel.timer.stop();

        } else {
            if (pathToPlayer.y > 0 && checkCollision(position.x, position.y + 1) == false) {
                position.translate(0, 1);

            }
            if (pathToPlayer.y < 0 && checkCollision(position.x, position.y - 1) == false) {
                position.translate(0, -1);

            }
        }
    }

    Boolean checkCollision(int xPos, int yPos) {
        collisionOn = false;
        if (screen.cellM.map[yPos][xPos] == 1    || screen.cellM.map[yPos][xPos] == 2 
           || screen.cellM.map[yPos][xPos] == 3  ||screen.cellM.map[yPos][xPos] == 15 
           || screen.cellM.map[yPos][xPos] == 16 || screen.cellM.map[yPos][xPos] == 18 
           || screen.cellM.map[yPos][xPos] == 19 || screen.cellM.map[yPos][xPos] == 20 
           || screen.cellM.map[yPos][xPos] == 21 || screen.cellM.map[yPos][xPos] == 22 
           || screen.cellM.map[yPos][xPos] == 23 || screen.cellM.map[yPos][xPos] == 24) {
            collisionOn = true;
        }
        return collisionOn;
    }
}