package com.group21.app.Entity;

import com.group21.app.Screen.*;

public class detectCollision {

    ScreenPanel screen;
    UI ui = UI.getInstance();

    public detectCollision(ScreenPanel screen){
        this.screen = screen;
    }


    public void checkCell(Entity entity){
         
        int[] newPos = new int[2];

        //System.out.println("("+entity.position.x+","+entity.position.y+")");

        switch(entity.direction){
            case "left":
                newPos[0] = entity.position.x-1;
                newPos[1] = entity.position.y;
                break;

            case "right":
                newPos[0] = entity.position.x+1;
                newPos[1] = entity.position.y;
                break;

            case "up":
                newPos[0] = entity.position.x;
                newPos[1] = entity.position.y-1;
                break;
            
            case "down":
                newPos[0] = entity.position.x;
                newPos[1] = entity.position.y+1;
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

            // Check if character collected all 20 rewards
            if (screen.character.rewardsCollected >= 5){ // CHANGE TO 20 LATER
                System.out.println("WIN");
                ui.makeWinWindow();
                ui.disposeGameWindow();
            }
            else{
                System.out.println("LOSE");
            }

        }
        // if chracter moves into a cell with a bow
        if (screen.cellM.map[newPos[1]][newPos[0]] == 8) {
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 50;
            screen.character.rewardsCollected++;
        }
        // if chracter moves into a cell with bread
        if (screen.cellM.map[newPos[1]][newPos[0]] == 9){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 20;
            screen.character.rewardsCollected++;
        }
        // if chracter moves into a cell with a dagger
        if (screen.cellM.map[newPos[1]][newPos[0]] == 10){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 50;
            screen.character.rewardsCollected++;
        }
        // if chracter moves into a cell with a spear
        if (screen.cellM.map[newPos[1]][newPos[0]] == 11){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 50;
            screen.character.rewardsCollected++;
        }
        // if chracter moves into a cell with water
        if (screen.cellM.map[newPos[1]][newPos[0]] == 12){
            screen.cellM.map[newPos[1]][newPos[0]] = 0;
            screen.character.score += 10;
            screen.character.rewardsCollected++;
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
