package com.group21.app.Entity;

import com.group21.app.Screen.*;

public class detectCollision {

    ScreenPanel screen;

    public detectCollision(ScreenPanel screen){
        this.screen = screen;
    }

    public void checkCell(Entity entity){

        /* 
            IDEA
            GET PLAYER POSITION
            GET CELL MAP AT PLAYER POSITION
            IF cellmap at player position == 2 then collosionOn = true so the character cannot go in that direction
        
            TODO:
                1. Lava logic- If player walks in lava show end screen
                2. Mount doom logic- If player walks in mount Doom show end screen    
        */
         
         int[] newPos = new int[2];

        System.out.println("("+entity.xPos+","+entity.yPos+")");

        switch(entity.direction){
            case "left":
                newPos[0] = entity.xPos-1;
                newPos[1] = entity.yPos;
                break;

            case "right":
                newPos[0] = entity.xPos+1;
                newPos[1] = entity.yPos;
                break;

            case "up":
                newPos[0] = entity.xPos;
                newPos[1] = entity.yPos-1;
                break;
            
            case "down":
                newPos[0] = entity.xPos;
                newPos[1] = entity.yPos+1;
                break;
        }
        // If character moves into a rock
        if (screen.cellM.map[newPos[1]][newPos[0]] == 2 || screen.cellM.map[newPos[1]][newPos[0]] == 3){
            entity.collisionOn = true;
        }
        // If character moves into lava
        if (screen.cellM.map[newPos[1]][newPos[0]] == 1){
            System.out.println("lava");
        } 
        // If character moves into mount doom
        if (screen.cellM.map[newPos[1]][newPos[0]] == 4){
            System.out.println("Mount DOOM");
        }
        // if chracter moves into a cell with a bow
        if (screen.cellM.map[newPos[1]][newPos[0]] == 8) {
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 50;
        }
        // if chracter moves into a cell with bread
        if (screen.cellM.map[newPos[1]][newPos[0]] == 9){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 20;
        }
        // if chracter moves into a cell with a dagger
        if (screen.cellM.map[newPos[1]][newPos[0]] == 10){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 50;
        }
        // if chracter moves into a cell with a spear
        if (screen.cellM.map[newPos[1]][newPos[0]] == 11){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 50;
        }
        // if chracter moves into a cell with water
        if (screen.cellM.map[newPos[1]][newPos[0]] == 12){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 10;
        }
        // if chracter moves into a cell with gandalf (bonus)
        if (screen.cellM.map[newPos[1]][newPos[0]] == 13){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 100;
            screen.gandalf.token = true;
        }
        // if chracter moves into a cell with sam (bonus)
        if (screen.cellM.map[newPos[1]][newPos[0]] == 14){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 100;
            screen.sam.token = true;
        }
    }
}
