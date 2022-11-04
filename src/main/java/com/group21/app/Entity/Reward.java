package com.group21.app.Entity;

import com.group21.app.Screen.ScreenPanel;

/**
 * This class creates an entity for rewards
 * This class handles the placement of rewards on the screen
 */
public class Reward extends Entity {
    ScreenPanel screen;
    private int[][] map;
    public int xPos;
    public int yPos;

    /**
     * This constructor loads reward's image and sets its initial position on the screen.
     *
     * @param screen instance of ScreenPanel in which to load the reward
     * @see ScreenPanel
     * @param id the specific type of reward
     * @param m cell map of the game
     * @param x x-coordinate of the reward on the map
     * @param y y-coordinate of the reward on the map
     * @author jeffreywong
     */
    public Reward(ScreenPanel s, int id, int[][] m, int x, int y) {
        screen = s;
        map = m;
        xPos = x;
        yPos = y;
        screen.cellM.map[xPos][yPos] = id;
        //spawnReward(map, id);
    }
    // public void spawnReward(int[][] map, int id) {
    //     screen.cellM.map[xPos][yPos] = id;
    // }

}
