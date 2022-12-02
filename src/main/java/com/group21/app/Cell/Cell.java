package com.group21.app.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * This class holds attributes for each cell in CellMap.
 * <p>
 * Values for Cell.type:
 * <p>
 *      "empty", "rock", "lava", "mount doom", "bow", "bread", "dagger", "spear",
 *      "water", "gandalf", "sam", "orc", "shelob", "witch", "smeagol", "sauron", "web"
 *
 * @see CellMap
 * @author Preet
 */
public class Cell {
    public Image img;
    public String type;
    public boolean collision  = false;
}
