package com.group21.app.Screen;

import com.group21.app.Screen.ScreenPanel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the JPanel classes for the title, rule, and game panels.
 *
 * @author Preet
 */
public class ScreenTest {
    UI ui;

    @Before
    public void init() {
        ui = UI.getInstance();
    }

    @Test
    public void testUIPanels() {
        assertEquals("Incorrect panel shown", "titlePanel", UI.gameState);
    }

}
