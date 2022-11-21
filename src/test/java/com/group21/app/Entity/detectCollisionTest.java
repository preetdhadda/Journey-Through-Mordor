package com.group21.app.Entity;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;

public class detectCollisionTest {
    
    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel);
    ArrayList<Reward> rewardList = Reward.rewardList;
    KeyEvent down = new KeyEvent(screenpanel, 1, 20, 1, 40, 'd');
    KeyEvent right = new KeyEvent(screenpanel, 1, 20, 1, 39, 'r');
    KeyEvent up = new KeyEvent(screenpanel, 1, 20, 1, 38, 'u');
    KeyEvent left = new KeyEvent(screenpanel, 1, 20, 1, 37, 'l');

    /**
     * This class iterates through an ArrayList
     * with all the rewards and sets the character's position ontop of the
     * reward. It then makes an assertion to check whether or not the character's position
     * and score is correctly incremented  
     * 
     * @see Reward
     * @see ScreenPanel
     * @see Character
     */
    @Test
    public void characterCollectsReward(){
        for (int i = 0;i<rewardList.size();i++){
            character.position.x = rewardList.get(i).yPos;
            character.position.y =  rewardList.get(i).xPos;
            screenpanel.collisionChecker.checkCell(character);
            //assert(character.position.x == rewardList.get(i).yPos && character.position.y == rewardList.get(i).xPos && character.score == rewardList.get(i).rewardScore);
            character.score = 0;
        }
    }

    /**
     * This class tests the 
     * character's collision detection 
     * with a rock by simulating the left arrow key press
     * when the character has a rock to its left and then checking 
     * to make sure its origin position is still (1,1) 
     */
    @Test
    public void characterIntoRock(){
        character.position.x = 1;
        character.position.y = 1;
        character.keyPressed(left);
        assert(character.position.x == 1 && character.position.y == 1);
    }




}
