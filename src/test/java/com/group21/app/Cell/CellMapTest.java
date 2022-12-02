package com.group21.app.Cell;

import com.group21.app.Screen.ScreenPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

import java.util.Timer;

/**
 * This class tests the construction of the cell map.
 *
 * @author Preet
 */
public class CellMapTest {
    ScreenPanel screen;
    CellMap cellMap;

    String cellTypeCheck[] = {"empty", "lava", "rock", "rock", "mount doom", "mount doom",
            "mount doom", "mount doom", "bow", "bread", "dagger", "spear", "water",
            "gandalf", "sam", "orc", "shelob", "witch", "smeagol", "sauron", "sauron",
            "sauron", "sauron", "web"};

    /**
     * First, we want to build a map on which to test.
     */
    @Before
    public void buildMap() {
        screen = ScreenPanel.getInstance();
        cellMap = new CellMap(screen);
        cellMap.loadCellImage();
    }

    /**
     * This test checks to see if each cell is set to the
     * correct type. Checking this will verify that the correct
     * cell image is displayed for each cell.
     */
    @Test
    public void mapTest() {
        for (int row = 0; row < screen.numRows; row++) {
            for (int col = 0; col < screen.numColumns; col++) {
                int num = cellMap.map[row][col];

                assertEquals("Incorrect cell type", cellMap.cell[num].type, cellTypeCheck[num]);
            }
        }
    }

}
