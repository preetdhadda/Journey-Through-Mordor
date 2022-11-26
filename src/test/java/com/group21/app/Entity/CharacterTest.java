package com.group21.app.Entity;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

/**
 * This class tests character movement 
 * from keyboard input
 * 
 * @author Jimmy Hui
 */
public class CharacterTest {
    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel,"left");
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
        Character character = new Character(screenpanel,"left");
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

    /**
     * This tests the keyboard movement for the down key
     * 
     */
    @Test
    public void characterMovesDown(){
        character.position.x = 1;
        character.position.y = 1;
        character.keyPressed(down);
        assertEquals("Character's down key is incorrect", 2, character.position.y);
    }

    /**
     * This tests the keyboard movement for the dowleftn key
     * 
     */
    @Test
    public void characterMovesLeft(){
        character.position.x = 2;
        character.position.y = 1;
        character.keyPressed(left);
        assertEquals("Character's left key is incorrect", 1, character.position.x);
    }
}
