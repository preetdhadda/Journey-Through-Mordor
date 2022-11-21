package com.group21.app.Entity;


import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import com.group21.app.Screen.ScreenPanel;


public class detectCollisionTest {
    
    ScreenPanel screenpanel = ScreenPanel.getInstance();
    Character character = new Character(screenpanel);
    ArrayList<Reward> rewardList = Reward.rewardList;

    /**
     * This class iterates through an ArrayList
     * with all the rewards and sets the character's position ontop of the
     * reward. It then makes an assertion to check whether or not the character's position
     * and score is correctly incremented  
     * 
     * @see Reward
     * @see ScreenPanel
     * @see Character
     */
    @Test
    public void characterCollectsReward(){
        
        for (int i = 0;i<rewardList.size();i++){
            character.position.x = rewardList.get(i).yPos;
            character.position.y =  rewardList.get(i).xPos;
            screenpanel.collisionChecker.checkCell(character);
            assert(character.position.x == rewardList.get(i).yPos && character.position.y == rewardList.get(i).xPos && character.score == rewardList.get(i).rewardScore);
            character.score = 0;
        }
    }

}
