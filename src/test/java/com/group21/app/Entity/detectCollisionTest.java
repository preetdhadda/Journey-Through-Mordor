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
 * 
 * @author Jimmy Hui
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
     * This test the character collision with water
     */
    @Test
    public void characterIntoWater(){
        Character.score = 0;
        character.position.x = 3;
        character.position.y = 1;
        character.keyPressed(right);
        assertEquals("Character's x position is incorrect",4,character.position.x);
        assertEquals("Character's y position is incorrect",1,character.position.y);
        assertEquals("Character's score is not decremented correctly", 10, Character.score);
    }

    /**
     * This test the character collision with bread
     */
    @Test
    public void characterIntoBread(){
        Character.score = 0;
        character.position.x = 1;
        character.position.y = 6;
        character.keyPressed(down);
        assertEquals("Character's x position is incorrect",1,character.position.x);
        assertEquals("Character's y position is incorrect",7,character.position.y);
        assertEquals("Character's score is not decremented correctly", 20, Character.score);
    }

    /**
     * This test the character collision with the bow
     */
    @Test
    public void characterIntoBow(){
        Character.score = 0;
        character.position.x = 1;
        character.position.y = 12;
        character.keyPressed(down);
        assertEquals("Character's x position is incorrect",1,character.position.x);
        assertEquals("Character's y position is incorrect",13,character.position.y);
        assertEquals("Character's score is not decremented correctly", 50, Character.score);
    }

    /**
     * This test the character collision with dagger
     */
    @Test
    public void characterIntoDagger(){
        Character.score = 0;
        character.position.x = 27;
        character.position.y = 4;
        character.keyPressed(right);
        assertEquals("Character's x position is incorrect",28,character.position.x);
        assertEquals("Character's y position is incorrect",4,character.position.y);
        assertEquals("Character's score is not decremented correctly", 50, Character.score);
    }

    /**
     * This test the character collision with spear
     */
    @Test
    public void characterIntoSpear(){
        Character.score = 0;
        character.position.x = 14;
        character.position.y = 1;
        character.keyPressed(left);
        assertEquals("Character's x position is incorrect",13,character.position.x);
        assertEquals("Character's y position is incorrect",1,character.position.y);
        assertEquals("Character's score is not decremented correctly", 50, Character.score);
    }

    /**
     * This test the character collision with Gandalf
     */
    @Test
    public void characterIntoGandalf(){
        Character.score = 0;
        character.position.x = 23;
        character.position.y = 7;
        character.keyPressed(up);
        assertEquals("Character's x position is incorrect",23,character.position.x);
        assertEquals("Character's y position is incorrect",6,character.position.y);
        assertEquals("Character's score is not decremented correctly", 100, Character.score);
    }

    /**
     * This test the character collision with Sam
     */
    @Test
    public void characterIntoSam(){
        Character.score = 0;
        character.position.x = 8;
        character.position.y = 12;
        character.keyPressed(down);
        assertEquals("Character's x position is incorrect",8,character.position.x);
        assertEquals("Character's y position is incorrect",13,character.position.y);
        assertEquals("Character's score is not decremented correctly", 100, Character.score);
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
        assertEquals("Character's x position is incorrect (did not detect rock)",1,character.position.x);
        assertEquals("Character's y position is incorrect (did not detect rock)",1,character.position.y);
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
        assertEquals("Character's x position is incorrect (did not detect lava)",9,character.position.x);
        assertEquals("Character's y position is incorrect (did not detect lava)",9,character.position.y);
        assertEquals("Character's score is not decremented correctly", 50, Character.score);
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
        assertEquals("Character's x position is incorrect (did not detect spider web)",7,character.position.x);
        assertEquals("Character's y position is incorrect (did not detect spider web)",3,character.position.y);
        assertEquals("Character's score is not decremented correctly",50, Character.score);
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
       assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",12,character.position.x);
       assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",6,character.position.y);
       assertEquals("Character's score is not decremented correctly", 100, Character.score);
   }


}
