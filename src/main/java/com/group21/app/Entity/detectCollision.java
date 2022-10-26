package com.group21.app.Entity;

import com.group21.app.Screen.*;

import java.util.Map;
import com.group21.app.Cell.*;

public class detectCollision {

    Screen screen;

    public detectCollision(Screen screen){
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

        switch(entity.direction){
            case "left":
                newPos[0] = entity.xPos;
                newPos[1] = entity.yPos-1;
                
                // If character moves into a rock
                if (screen.cellM.map[newPos[0]][newPos[1]] == 2 || screen.cellM.map[newPos[0]][newPos[1]] == 3){
                    entity.collisionOn = true;
                }
                
                // If character moves into lava
                if (screen.cellM.map[newPos[0]][newPos[1]] == 1){
                    System.out.println("lava");
                }

                // If character moves into mount doom
                if (screen.cellM.map[newPos[0]][newPos[1]] == 4){
                    System.out.println("Mount DOOM");
                }
                break;

            case "right":
                newPos[0] = entity.xPos;
                newPos[1] = entity.yPos+1;

                // If character moves into a rock
                if (screen.cellM.map[newPos[0]][newPos[1]] == 2 || screen.cellM.map[newPos[0]][newPos[1]] == 3){
                    entity.collisionOn = true;
                }

                // If character moves into lava
                if (screen.cellM.map[newPos[0]][newPos[1]] == 1){
                    System.out.println("lava");
                }         
                
                // If character moves into mount doom
                if (screen.cellM.map[newPos[0]][newPos[1]] == 4){
                    System.out.println("Mount DOOM");
                }
                break;

            case "up":
                newPos[0] = entity.xPos-1;
                newPos[1] = entity.yPos;

                // If character moves into a rock
                if (screen.cellM.map[newPos[0]][newPos[1]] == 2 || screen.cellM.map[newPos[0]][newPos[1]] == 3){
                    entity.collisionOn = true;
                }
                
                // If character moves into lava
                if (screen.cellM.map[newPos[0]][newPos[1]] == 1){
                    System.out.println("lava");
                }  

                // If character moves into mount doom
                if (screen.cellM.map[newPos[0]][newPos[1]] == 4){
                    System.out.println("Mount DOOM");
                }
                break;
            
            case "down":
                newPos[0] = entity.xPos+1;
                newPos[1] = entity.yPos;

                // If character moves into a rock
                if (screen.cellM.map[newPos[0]][newPos[1]] == 2 || screen.cellM.map[newPos[0]][newPos[1]] == 3){
                    entity.collisionOn = true;
                }

                // If character moves into lava
                if (screen.cellM.map[newPos[0]][newPos[1]] == 1){
                    System.out.println("lava");
                }  

                // If character moves into mount doom
                if (screen.cellM.map[newPos[0]][newPos[1]] == 4){
                    System.out.println("Mount DOOM");
                }
                break;
        }
    }
}
