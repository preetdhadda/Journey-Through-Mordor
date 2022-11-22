package com.group21.app.Screen;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

/**
 * This class tests the JPanel classes for the UI and the
 * title, rule, and game/menu panels.
 *
 * @author Preet
 */
public class UITest {
    UI ui;

    /**
     * First, let's create an instance of UI
     */
    @Before
    public void init() {
        ui = UI.getInstance();
        ui.makeTitleWindow();
    }

    /**
     * This test is checking whether the correct JPanel is displayed
     * when the user is navigating through UI button options.
     */
    @Test
    public void testUIPanels() {
        assertEquals("Incorrect panel shown", "titlePanel", UI.gameState);
        ui.titlePanel.playBTN.doClick();
        assertEquals("Incorrect panel shown", "rulePanel", UI.gameState);
        ui.rulepanel.continueBTN.doClick();
        assertEquals("Incorrect panel shown", "menupanel", UI.gameState);
    }

}
