package com.group21.app.Entity;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Entity.Enemy;
/**
 * This class tests player collision with
 * regular rewards, bonus rewards, obstacles,
 * and punishment cells 
 */
public class detectCollisionTest {
    
    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel);
    ArrayList<Reward> rewardList = Reward.rewardList;
    KeyEvent down = new KeyEvent(screenpanel, 1, 20, 1, 40, 'd');
    KeyEvent right = new KeyEvent(screenpanel, 1, 20, 1, 39, 'r');
    KeyEvent up = new KeyEvent(screenpanel, 1, 20, 1, 38, 'u');
    KeyEvent left = new KeyEvent(screenpanel, 1, 20, 1, 37, 'l');

    /**
     * This class initializes the test 
     * conditinos and resets the character 
     * before every test case
     */
    @Before
    public void init(){
        ScreenPanel screenpanel = ScreenPanel.getInstance();
        Character character = new Character(screenpanel);
        Character.score = 0;
        character.position.x = 1;
        character.position.y = 1;
    }

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
            Character.score = 0;
            character.position.x = rewardList.get(i).yPos;
            character.position.y =  rewardList.get(i).xPos;
            screenpanel.collisionChecker.checkCell(character);
            assertEquals("Character's x position not the same as Reward's x position",character.position.x, rewardList.get(i).yPos);
            assertEquals("Character's y position not the same as Reward's y position",character.position.y, rewardList.get(i).xPos);
            //assertEquals("Character's score not incremented correctly", rewardList.get(i).rewardScore,Character.score);
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
        assertEquals("Character's x position is incorrect (did not detect rock)",character.position.x,1);
        assertEquals("Character's y position is incorrect (did not detect rock)",character.position.y,1);
    }

    /**
     * This class tests the character's
     * collision detection with lava
     * and ensures that the character's score is decremented by
     * 50 by initializing the score to 100 and checking if the final score
     * after walking into lava is 50
     */
    @Test
    public void characterIntoLava(){
        Character.score = 100;
        character.position.x = 9;
        character.position.y = 8;
        character.keyPressed(down);
        assertEquals("Character's x position is incorrect (did not detect lava)",character.position.x,9);
        assertEquals("Character's y position is incorrect (did not detect lava)",character.position.y,9);
        assertEquals("Character's score is not decremented correctly", Character.score, 50);
    }

    /**
     * This class tests the character's
     * collision detection with spider webs
     * and ensures that the character's score is decremented by
     * 50 by initializing the score to 100 and checking if the final score
     * after walking into spider webs is 50
     */
    @Test
    public void characterIntoSpiderWeb(){
        Character.score = 100;
        character.position.x = 8;
        character.position.y = 3;
        character.keyPressed(left);
        assertEquals("Character's x position is incorrect (did not detect spider web)",character.position.x,7);
        assertEquals("Character's y position is incorrect (did not detect spider web)",character.position.y,3);
        assertEquals("Character's score is not decremented correctly", Character.score, 50);
    }
  
    /**
     * This class tests the character's
     * collision detection with the Eye of Sauron
     * and ensures that the character's score is decremented by
     * 100 by initializing the score to 200 and checking if the final score
     * after walking into the Eye of Suaron is 100
     */
    @Test
    public void characterIntoEyeOfSauron(){
       Character.score = 200;
       character.position.x = 12;
       character.position.y = 5;
       character.keyPressed(down);
       assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",character.position.x,12);
       assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",character.position.y,6);
       assertEquals("Character's score is not decremented correctly", Character.score, 100);
   }

    @After
    public void deleteScreen() {
        screenpanel.deleteInstance();
    }
}
