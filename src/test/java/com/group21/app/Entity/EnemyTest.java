package com.group21.app.Entity;
import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;
import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Screen.UI;

public class EnemyTest {

    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel,"left");

    public static Enemy gollum;
    public static Enemy ork;
    public static Enemy shelob;
    public static Enemy witch_king;

    KeyEvent down = new KeyEvent(screenpanel, 1, 20, 1, 40, 'd');
    KeyEvent right = new KeyEvent(screenpanel, 1, 20, 1, 39, 'r');
    KeyEvent up = new KeyEvent(screenpanel, 1, 20, 1, 38, 'u');
    KeyEvent left = new KeyEvent(screenpanel, 1, 20, 1, 37, 'l');

    @Before
    public void init(){
        ScreenPanel screenpanel = ScreenPanel.getInstance();
        Character character = new Character(screenpanel,"left");
        Character.score = 0;
        character.position.x = 1;
        character.position.y = 1;

        ork = new Enemy(screenpanel,"orc",1,13);
        shelob = new Enemy(screenpanel,"shelob",6, 4);
        witch_king = new Enemy(screenpanel,"witch_king",26, 2);
        gollum = new Enemy(screenpanel, "gollum", 24, 11);
    }

    /**
     * This tests the enemies collision with water
     */
    @Test
    public void enemyWaterCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(4,1));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(4,1));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(4,1));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(4,1));
    }

    /**
     * This test the enemies collision with bread
     */
    @Test
    public void enemyBreadCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(1,7));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(1,7));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(1,7));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(1,7));
    }

    /**
     * This test the enemies collision with the bow
     */
    @Test
    public void enemyBowCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(1,13));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(1,13));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(1,13));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(1,13));
    }

    /**
     * This tests the enemies collision with dagger
     */
    @Test
    public void enemyDaggerCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(28,4));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(28,4));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(28,4));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(28,4));
    }

    /**
     * This tests the enemies collision with spear
     */
    @Test
    public void enemySpearCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(13,1));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(13,1));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(13,1));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(13,1));
    }

    /**
     * This tests the enemies collision with Gandalf
     */
    @Test
    public void enemyGandalfCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(23,6));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(23,6));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(23,6));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(23,6));
    }

    /**
     * This tests the enemies collision with Sam
     */
    @Test
    public void enemySamCollision(){
        assertEquals("Enemy Ork water collision",false, ork.checkObjectCollision(8,13));
        assertEquals("Enemy Shelob water collision",false, shelob.checkObjectCollision(8,13));
        assertEquals("Enemy Witch king water collision",false, witch_king.checkObjectCollision(8,13));
        assertEquals("Enemy Gollum water collision",false, gollum.checkObjectCollision(8,13));
    }

    /**
     * This class tests the enemies collision detection with a rock
     */
    @Test
    public void enemyIntoRockCollision(){
        assertEquals("Enemy Ork water collision",true, ork.checkObjectCollision(0,0));
        assertEquals("Enemy Shelob water collision",true, shelob.checkObjectCollision(0,0));
        assertEquals("Enemy Witch king water collision",true, witch_king.checkObjectCollision(0,0));
        assertEquals("Enemy Gollum water collision",true, gollum.checkObjectCollision(0,0));
    }

    /**
     * This class tests the enemies collision detection with lava
     */
    @Test
    public void enemyIntoLavaCollision(){
        assertEquals("Enemy Ork water collision",true, ork.checkObjectCollision(9,9));
        assertEquals("Enemy Shelob water collision",true, shelob.checkObjectCollision(9,9));
        assertEquals("Enemy Witch king water collision",true, witch_king.checkObjectCollision(9,9));
        assertEquals("Enemy Gollum water collision",true, gollum.checkObjectCollision(9,9));
    }

    /**
     * This class tests the enemies collision detection with spider webs
     */
    @Test
    public void enemyIntoSpiderWebCollision(){
        assertEquals("Enemy Ork water collision",true, ork.checkObjectCollision(7,3));
        assertEquals("Enemy Shelob water collision",true, shelob.checkObjectCollision(7,3));
        assertEquals("Enemy Witch king water collision",true, witch_king.checkObjectCollision(7,3));
        assertEquals("Enemy Gollum water collision",true, gollum.checkObjectCollision(7,3));
    }

    /**
     * This class tests the enemies collision detection with the Eye of Sauron
     */
    @Test
    public void enemyIntoEyeOfSauronCollision(){
        assertEquals("Enemy Ork water collision",true, ork.checkObjectCollision(12,7));
        assertEquals("Enemy Shelob water collision",true, shelob.checkObjectCollision(12,7));
        assertEquals("Enemy Witch king water collision",true, witch_king.checkObjectCollision(12,7));
        assertEquals("Enemy Gollum water collision",true, gollum.checkObjectCollision(12,7));
   }

   // Enemy Player Collision check

    /**
     * This class tests the enemies collision with player
     */
    @Test
    public void EnemyMovesIntoCharacter(){
         Character.score = 100;
         character.position.x = 1;
         character.position.y = 2;
         Character.rewardsCollected = 20;

         character.keyPressed(down);

         ork = new Enemy(screenpanel,"orc",1,3);

        Point pathToPlayer = new Point((character.position.x - ork.position.x),(character.position.y - ork.position.y));

         assertEquals("Enemy - Ork walks into character",0, pathToPlayer.x);
         assertEquals("Enemy - Ork walks into character",0, pathToPlayer.y);

         ork.moveToPlayer(character);
         assertEquals("Enemy - Shelob walks into character",true, Enemy.playerFound);
         assertEquals("Incorrect game screen is shown", "losePanel", UI.gameState);
    }

    @Test
    public void EnemyMovement(){
        ork = new Enemy(screenpanel,"orc",2,3);
        ork.imageFacingDirection = "right";
        ork.position.translate(1, 0);
        assertEquals(ork.position.x, 3);
        assertEquals(ork.position.y, 3);
        assertEquals(ork.imageFacingDirection, "right");

        ork = new Enemy(screenpanel,"orc",2,3);
        ork.imageFacingDirection = "left";
        ork.position.translate(-1, 0);
        assertEquals(ork.position.x, 1);
        assertEquals(ork.position.y, 3);
        assertEquals(ork.imageFacingDirection, "left");

        // up
        ork = new Enemy(screenpanel,"orc",2,3);
        ork.position.translate(0, -1);
        assertEquals(ork.position.y, 2);
        assertEquals(ork.position.x, 2);

        // down
        ork = new Enemy(screenpanel,"orc",2,3);
        ork.position.translate(0, 1);
        assertEquals(ork.position.y, 4);
        assertEquals(ork.position.x, 2);
    }
}
