package com.group21.app.Entity;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;
import com.group21.app.Entity.Enemy;
/**
 * This class tests player collision with
 * regular rewards, bonus rewards, obstacles,
 * punishment cells. It also checks the collision
 * with the end goal (Mount Doom) with different values of 
 * rewardsCollected. In addition, it also checks
 * whether the correct screen is shown after the 
 * replay button is pressed.
 * 
 * @author Jimmy Hui
 */
public class detectCollisionTest {

    UI ui;
    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel,"left");
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
        Character character = new Character(screenpanel,"left");
        Character.score = 0;
        character.position.x = 1;
        character.position.y = 1;
        ui = UI.getInstance();
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
     * This class tests the
     * character's collision detection
     * with a rock by simulating the left arrow key press
     * when the character has a rock to its left and then checking
     * to make sure its origin position is still (1,1)
     */
    @Test
    public void characterIntoLavaRock(){
        character.position.x = 14;
        character.position.y = 9;
        character.keyPressed(right);
        assertEquals("Character's x position is incorrect (did not detect rock)",14,character.position.x);
        assertEquals("Character's y position is incorrect (did not detect rock)",9,character.position.y);
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
    public void characterIntoEyeOfSauronTopLeft(){
       Character.score = 200;
       character.position.x = 12;
       character.position.y = 5;
       character.keyPressed(down);
       assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",12,character.position.x);
       assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",6,character.position.y);
       assertEquals("Character's score is not decremented correctly", 100, Character.score);
   }

    /**
     * This class tests the character's
     * collision detection with the Eye of Sauron
     * and ensures that the character's score is decremented by
     * 100 by initializing the score to 200 and checking if the final score
     * after walking into the Eye of Suaron is 100
     */
    @Test
    public void characterIntoEyeOfSauronTopRight(){
       Character.score = 200;
       character.position.x = 13;
       character.position.y = 5;
       character.keyPressed(down);
       assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",13,character.position.x);
       assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",6,character.position.y);
       assertEquals("Character's score is not decremented correctly", 100, Character.score);
   }

       /**
     * This class tests the character's
     * collision detection with the Eye of Sauron
     * and ensures that the character's score is decremented by
     * 100 by initializing the score to 200 and checking if the final score
     * after walking into the Eye of Suaron is 100
     */
    @Test
    public void characterIntoEyeOfSauronBotLeft(){
       Character.score = 200;
       character.position.x = 12;
       character.position.y = 8;
       character.keyPressed(up);
       assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",12,character.position.x);
       assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",7,character.position.y);
       assertEquals("Character's score is not decremented correctly", 100, Character.score);
   }

       /**
     * This class tests the character's
     * collision detection with the Eye of Sauron
     * and ensures that the character's score is decremented by
     * 100 by initializing the score to 200 and checking if the final score
     * after walking into the Eye of Suaron is 100
     */
    @Test
    public void characterIntoEyeOfSauronBotRight(){
       Character.score = 200;
       character.position.x = 13;
       character.position.y = 8;
       character.keyPressed(up);
       assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",13,character.position.x);
       assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",7,character.position.y);
       assertEquals("Character's score is not decremented correctly", 100, Character.score);
   }

    /**
     * This class is designed to test if the lose screen is shown when
     * the character's score becomes negative. To do this, we will start
     * of 99, walking into the Eye of Sauron will give a score of -1,
     * and the lose screen should be displayed.
     *
     * @author Preet
     */
    @Test
    public void characterHasNegativeOneScore(){
        Character.score = 99;
        character.position.x = 12;
        character.position.y = 5;
        character.keyPressed(down);
        assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",12,character.position.x);
        assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",6,character.position.y);
        assertEquals("Incorrect game screen is shown", "losePanel", UI.gameState);
    }

    /**
     * This class is designed to test if the lose screen is shown when
     * the character's score becomes negative. To do this, we will start
     * of 0, walking into the Eye of Sauron will give a score of -100, and
     * the lose screen should be displayed.
     *
     * @author Preet
     */
    @Test
    public void characterHasNegative100Score(){
        Character.score = 0;
        character.position.x = 12;
        character.position.y = 5;
        character.keyPressed(down);
        assertEquals("Character's x position is incorrect (did not detect Eye Of Sauron)",12,character.position.x);
        assertEquals("Character's y position is incorrect (did not detect Eye Of Sauron)",6,character.position.y);
        assertEquals("Incorrect game screen is shown", "losePanel", UI.gameState);
    }

       /**
     * This class tests the character's
     * collision detection with Mount Doom
     * when score >= 0 and collectAllRewards is 20 (true).
        * It also tests that the win screen is shown and the
        * replay button on the win screen works.
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
         ui.winpanel.replayBTN.doClick();
         assertEquals("Incorrect game screen is shown", "menupanel",UI.gameState);
    }
 
    /**
     * This class tests the character's
     * collision detection with Mount Doom
     * when score >= 0 and collectAllRewards is 0 (false).
     * It also tests that the lose screen is shown and the
     * replay button on the lose screen works.
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
        ui.losepanel.replayBTN.doClick();
        assertEquals("Incorrect game screen is shown", "menupanel",UI.gameState);
    }
 
    /**
     * This class tests the character's
     * collision detection with Mount Doom
     * when score >= 0 and collectAllRewards is 19 (false)
     */
    @Test
    public void characterIntoMountDoomAndNineTeenRewardsCollected(){
        Character.score = 100;
        character.position.x = 27;
        character.position.y = 11;
        Character.rewardsCollected = 19;
        character.keyPressed(down);
        assertEquals("Character's x position is not correct", 27, character.position.x);
        assertEquals("Character's y position is not correct", 12, character.position.y);
        assertEquals("Incorrect game screen is shown", "losePanel", UI.gameState);
        ui.losepanel.replayBTN.doClick();
        assertEquals("Incorrect game screen is shown", "menupanel",UI.gameState);
    }

    /**
    * This class tests the character's
    * collision detection with Mount Doom
    * when score >= 0 and collectAllRewards is 25 (true)
    */
    @Test
    public void characterIntoMountDoomAndTwentyFiveRewardsCollected(){
         Character.score = 100;
         character.position.x = 27;
         character.position.y = 11;
         Character.rewardsCollected = 25;
         character.keyPressed(down);
         assertEquals("Character's x position is not correct", 27, character.position.x);
         assertEquals("Character's y position is not correct", 12, character.position.y);
         assertEquals("Incorrect game screen is shown", "winPanel", UI.gameState);
         ui.losepanel.replayBTN.doClick();
         assertEquals("Incorrect game screen is shown", "menupanel",UI.gameState);
    }
}
