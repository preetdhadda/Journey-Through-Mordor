package com.group21.app.Entity;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

/**
 * This class tests character movement from 
 * keyboard input, and win/lose conditions
 * when the character reaches the end (Mount Doom)
 * 
 * @author Jimmy Hui
 */
public class CharacterTest {
    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel);
    KeyEvent down = new KeyEvent(screenpanel, 1, 20, 1, 40, 'd');
    KeyEvent right = new KeyEvent(screenpanel, 1, 20, 1, 39, 'r');
    KeyEvent left = new KeyEvent(screenpanel, 1, 20, 1, 37, 'l');
    KeyEvent up = new KeyEvent(screenpanel, 1, 20, 1, 38, 'u');

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
     * This tests the keyboard movement for the up key
     * 
     */
    @Test
    public void characterMovesUp(){
        character.position.x = 1;
        character.position.y = 2;
        character.keyPressed(up);
        assertEquals("Character's up key is incorrect", 1, character.position.y);
    }

    /**
     * This tests the keyboard movement for the right key
     * 
     */
    @Test
    public void characterMovesRight(){
        character.position.x = 1;
        character.position.y = 1;
        character.keyPressed(right);
        assertEquals("Character's right key is incorrect", 2, character.position.x);
    }

    @Test
    public void characterMovesDown(){
        character.position.x = 1;
        character.position.y = 1;
        character.keyPressed(down);
        assertEquals("Character's down key is incorrect", 2, character.position.y);
    }
    @Test
    public void characterMovesLeft(){
        character.position.x = 2;
        character.position.y = 1;
        character.keyPressed(left);
        assertEquals("Character's left key is incorrect", 1, character.position.x);
    }

    /**
     * This class tests the character's
     * collision detection with Mount Doom
     * when score >= 0 and collectAllRewards is true
     */
   @Test
   public void characterIntoMountDoomAndRewardsCollected(){
        Character.score = 100;
        character.position.x = 27;
        character.position.y = 11;
        Character.rewardsCollected = 20;
        character.keyPressed(down);
        assertEquals("Character's x position is not correct", 27, character.position.x);
        assertEquals("Character's y position is not correct", 12, character.position.y);
        assertEquals("Incorrect game screen is shown", "winPanel", UI.gameState);
   }

    /**
     * This class tests the character's
     * collision detection with Mount Doom
     * when score >= 0 and collectAllRewards is false
     */
    @Test
    public void characterIntoMountDoomAndRewardsNotCollected(){
        Character.score = 100;
        character.position.x = 27;
        character.position.y = 11;
        Character.rewardsCollected = 0;
        character.keyPressed(down);
        assertEquals("Character's x position is not correct", 27, character.position.x);
        assertEquals("Character's y position is not correct", 12, character.position.y);
        assertEquals("Incorrect game screen is shown", "losePanel", UI.gameState);
    }

}
