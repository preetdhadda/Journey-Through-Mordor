package com.group21.app.Entity;

import com.group21.app.Screen.ScreenPanel;

public class Reward extends Entity {
    ScreenPanel screen;
    private int[][] map;
    public int xPos;
    public int yPos;

    public Reward(ScreenPanel s, int id, int[][] m, int x, int y) {
        screen = s;
        map = m;
        xPos = x;
        yPos = y;
        spawnReward(map, id);
    }
    public void spawnReward(int[][] map, int id) {
        screen.cellM.map[xPos][yPos] = id;
    }

}
