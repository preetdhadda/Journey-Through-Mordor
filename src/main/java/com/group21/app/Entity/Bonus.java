package com.group21.app.Entity;

import com.group21.app.Screen.ScreenPanel;

public class Bonus extends Reward {

    // token to keep track if a bonus is collected 
    public boolean token = false;

    // inherited from superclass Reward
    public Bonus(ScreenPanel s, int id, int[][] m, int x, int y) {
        super(s, id, m, x, y);
    }
    
}
