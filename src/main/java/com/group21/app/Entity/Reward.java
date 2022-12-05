package com.group21.app.Entity;

import java.util.ArrayList;


import com.group21.app.Screen.ScreenPanel;

/**
 * This class creates an entity for rewards
 * This class handles the placement of rewards on the screen
 */
public class Reward extends Entity {
    ScreenPanel screen;
    public int xPos;
    public int yPos;
    public int rewardScore;

    public static ArrayList<Reward> rewardList = new ArrayList<Reward>();

    /**
     * This constructor loads reward's image and sets its initial position on the screen.
     *
     * @param s instance of ScreenPanel in which to load the reward
     * @param id the specific type of reward
     * @param x x-coordinate of the reward on the map
     * @param y y-coordinate of the reward on the map
     * @see ScreenPanel
     * @author Jeffrey
     */
    public Reward(ScreenPanel s, int id, int x, int y, int score) {
        screen = s;
        xPos = x;
        yPos = y;
        rewardScore = score;
        screen.cellM.map[xPos][yPos] = id;
        rewardList.add(this);
    }
}
