package com.group21.app.Screen;

import com.group21.app.Screen.ScreenPanel;
import com.group21.app.Cell.CellMap;
import com.group21.app.Screen.MenuPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Timer;


/**
 * This class tests the timer displayed in the menu panel 
 * and the placement of bonus rewards with respect to time
 * 
 * 
 * @author Jeffrey
 */
public class timerTest {
    MenuPanel menu;
    ScreenPanel screen;

    /**
     * Initiate screen and menu panels
     */
    @Before
    public void setup() {
        screen = ScreenPanel.getInstance();
        menu = new MenuPanel(screen);
    }

    /**
     * This test checks that the seconds in time elapsed is valid
     */
    @Test
    public void secondsTest() {
        int second = menu.second;
        assertTrue("seconds should be within the range [0,60]", second >= 0 && second <= 60);
    } 

    /**
     * This test checks the placement of bonuses with respect to the time
     */
    @Test
    public void bonusGivenTimeTest() {
        int time = menu.second;

        if (time >=0 && time < 10) {
            if (!screen.gandalf.token) {
                assertEquals("Gandalf should appear in his starting position",13,screen.cellM.map[6][23]);
            } else {
                assertEquals("Gandalf has been collected and should not reappear",0,screen.cellM.map[6][23]);
            }

            if (!screen.sam.token) {
                assertEquals("Sam should appear in his starting position",14,screen.cellM.map[13][8]);
            } else {
                assertEquals("Sam has been collected and should not reappear",0,screen.cellM.map[13][8]);
            }
        } else if (time >= 10 && time <20) {
            assertEquals("No bonuses should be active currently",0,screen.cellM.map[13][8]);
            assertEquals("No bonuses should be active currently",0,screen.cellM.map[6][23]);
        } else if (time >= 20 && time < 30) {
            if (!screen.sam.token) {
                assertEquals("Sam should appear in Gandalf's starting position",14,screen.cellM.map[6][23]);
            } else {
                assertEquals("Sam has been collected and should not reappear",0,screen.cellM.map[6][23]);
            }
        } else if (time >= 30 && time < 40) {
            assertEquals("No bonuses should be active currently",0,screen.cellM.map[13][8]);
            assertEquals("No bonuses should be active currently",0,screen.cellM.map[6][23]);
        } else if (time >= 40 && time < 50) {
            if (!screen.gandalf.token) {
                assertEquals("Gandalf should appears in Sam's original position",13,screen.cellM.map[13][8]);
            } else {
                assertEquals("Gandalf has been collected and should not reappear",0,screen.cellM.map[13][8]);
            }
        } else { // time >= 50 && time <= 60
            assertEquals("No bonuses should be active currently",0,screen.cellM.map[13][8]);
            assertEquals("No bonuses should be active currently",0,screen.cellM.map[6][23]);
        }
    } 
}
