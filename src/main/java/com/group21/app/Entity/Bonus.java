package com.group21.app.Entity;

import com.group21.app.Screen.ScreenPanel;

/**
 * This class creates an entity for rewards
 * This class handles the placement of bonuses on the screen
 */
public class Bonus extends Reward {

    // token to keep track if a bonus is collected 
    public boolean token = false;

    /**
     * This constructor loads the bonus' image and sets its initial position on the screen.
     *
     * @param s instance of ScreenPanel in which to load the reward
     * @see ScreenPanel
     * @param id the specific type of reward
     * @param x x-coordinate of the reward on the map
     * @param y y-coordinate of the reward on the map
     * @author Jeffrey
     */
    public Bonus(ScreenPanel s, int id, int x, int y, int score) {
        // inherited from superclass Reward
        super(s, id, x, y, score);
    }
    
}
