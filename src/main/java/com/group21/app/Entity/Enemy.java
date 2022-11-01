package com.group21.app.Entity;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

import java.awt.*;

public class Enemy extends Entity {
    private Image characterLeft;
    private Image characterRight;
    private String imageDirection;
    ScreenPanel screen;
    public static boolean playerFound = false;
    private int id;

    public Enemy(ScreenPanel screen, String img_left, String img_Right, int x, int y, String imageDirection, int id,
            int[][] map) {
        this.characterLeft = new ImageIcon(img_left).getImage();
        this.characterRight = new ImageIcon(img_Right).getImage();
        position = new Point(x, y);
        this.screen = screen;
        this.imageDirection = imageDirection;
        this.id = id;

        screen.cellM.map[y][x] = id;
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

    public void moveToPlayer(Character _player) {

        Point ownCurrentLocation = position;
        Point playersLocation = _player.position;

        Point directionToPlayer = new Point((_player.position.x - ownCurrentLocation.x),
                (playersLocation.y - ownCurrentLocation.y));

        if (Math.abs((directionToPlayer.x)) > Math.abs((directionToPlayer.y))) {
            if (directionToPlayer.x > 0 && checkCollision(position.x + 1, position.y) == false) {
                screen.cellM.map[position.y][position.x] = 0;
                imageDirection = "right";
                position.translate(1, 0);

            } else if (directionToPlayer.x < 0 && checkCollision(position.x - 1, position.y) == false) {
                screen.cellM.map[position.y][position.x] = 0;
                imageDirection = "left";
                position.translate(-1, 0);
            }
        } else if (Math.abs((directionToPlayer.x)) < Math.abs((directionToPlayer.y))) {
            if (directionToPlayer.y > 0 && checkCollision(position.x, position.y + 1) == false) {
                screen.cellM.map[position.y][position.x] = 0;
                position.translate(0, 1); // Down

            } else if (directionToPlayer.y < 0 && checkCollision(position.x, position.y - 1) == false) {
                screen.cellM.map[position.y][position.x] = 0;
                position.translate(0, -1); // Up

            }
        } else if (Math.abs((directionToPlayer.x)) == Math.abs(0) && (directionToPlayer.y) == Math.abs(0)) {
            playerFound = true;
            UI ui = UI.getInstance();
            ui.makeLoseWindow("enemy");
            ui.disposeGameWindow();

        } else {
            if (directionToPlayer.y > 0 && checkCollision(position.x, position.y + 1) == false) {
                screen.cellM.map[position.y][position.x] = 0;
                position.translate(0, 1);

            }
            if (directionToPlayer.y < 0 && checkCollision(position.x, position.y - 1) == false) {
                screen.cellM.map[position.y][position.x] = 0;
                position.translate(0, -1);

            }
        }

        screen.cellM.map[position.y][position.x] = id;
    }

    Boolean checkCollision(int xPos, int yPos) {
        collisionOn = false;
        if (screen.cellM.map[yPos][xPos] == 1    || screen.cellM.map[yPos][xPos] == 2 
           || screen.cellM.map[yPos][xPos] == 3  ||screen.cellM.map[yPos][xPos] == 15 
           || screen.cellM.map[yPos][xPos] == 16 || screen.cellM.map[yPos][xPos] == 17
           || screen.cellM.map[yPos][xPos] == 18 || screen.cellM.map[yPos][xPos] == 19) {
            collisionOn = true;
        }
        return collisionOn;
    }
}