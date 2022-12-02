package com.group21.app.Cell;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;

import java.awt.*;

/**
 * This class creates a map of cells. This is what is used to render the map
 * on the screen.
 */
public class CellMap {
    ScreenPanel screen;
    public Cell cell[]; // array of cells
    public int map[][]; // 2d array to map the cells

    /**
     * This constructor sets the cell type in each cell in the 2d array.
     * <p>
     * Map legend:
     * <p>
     *     0 = plain background   |  10 =a dagger    |   16 = shelob
     * <p>
     *     1 = lava       |          11 = spear    |    18 = witch king
     * <p>
     *     2, 3 = rock       |       12 = water    |    19 = gollum
     * <p>
     *     4, 5, 6, 7 = volcano   |  13 = gandalf   |   20, 21, 22, 23 = eye of sauron
     * <p>
     *     8 = bow          |        14 = sam      |    24 = spider web
     * <p>
     *     9 = bread         |       15 = orc
     *
     * @param screen the instance of ScreenPanel to display the map on
     * @see ScreenPanel
     * @author Preet
     */
    public CellMap(ScreenPanel screen) {
        this.screen = screen;
        cell = new Cell[24];

        map = new int[][] {
            {2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2},
            {2 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 0 , 0 , 23 , 0 , 2 , 0 , 0 , 0 , 2 , 2 , 2 , 2 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 2},
            {2 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2},
            {2 , 0 , 2 , 0 , 0 , 0 , 0 , 23 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 1 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 2},
            {2 , 0 , 2 , 0 , 23 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 1 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2},
            {2 , 0 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 1 , 0 , 0 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2},
            {2 , 0 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 23 , 0 , 0 , 19 , 20 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 2 , 2 , 0 , 0 , 1 , 2},
            {2 , 0 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 21 , 22 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 , 2},
            {2 , 2 , 2 , 2 , 2 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 2 , 0 , 0 , 1 , 2},
            {2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 3 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 2 , 2 , 2 , 1 , 2},
            {2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 2},
            {2 , 0 , 1 , 1 , 1 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 2},
            {2 , 0 , 0 , 2 , 1 , 0 , 0 , 2 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 2 , 0 , 0 , 0 , 0 , 4 , 5 , 2},
            {2 , 0 , 0 , 2 , 0 , 0 , 0 , 2 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 3 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 6 , 7 , 2},
            {2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2}
        };

        loadCellImage();
    }

    /**
     * This method is a helper for loadCellImage() and it sets the cell attributes in
     * the cell map.
     *
     * @param num cell's index in the array of cells
     * @param fileName image location for the cell
     * @param cellType
     * @see Cell
     * @author Preet
     */
    public void createCell(int num, String fileName, String cellType) {
        cell[num] = new Cell();
        cell[num].img = new ImageIcon(fileName).getImage();
        cell[num].type = cellType;
    }

    /**
     * This method loads the images for each of the cells to be displayed on the screen
     * by calling the createCell() helper method
     *
     * @author Preet
     * @author Jeffrey
     * @author Jessy
     */
    public void loadCellImage() {
        // empty cell:
        createCell(0, "src/main/resources/images/background.png", "empty");

        // lava cell:
        createCell(1, "src/main/resources/images/lava.png", "lava");

        // rock cells:
        createCell(2, "src/main/resources/images/rock1.png", "rock");
        createCell(3, "src/main/resources/images/rock2.png", "rock");

        // mount doom cells:
        createCell(4, "src/main/resources/images/volcano_00.png", "mount doom");
        createCell(5, "src/main/resources/images/volcano_01.png", "mount doom");
        createCell(6, "src/main/resources/images/volcano_10.png", "mount doom");
        createCell(7, "src/main/resources/images/volcano_11.png", "mount doom");

        // reward cells:
        createCell(8, "src/main/resources/images/bow.png", "bow");
        createCell(9, "src/main/resources/images/bread.png", "bread");
        createCell(10, "src/main/resources/images/dagger.png", "dagger");
        createCell(11, "src/main/resources/images/spear.png", "spear");
        createCell(12, "src/main/resources/images/water.png", "water");

        // bonus cells:
        createCell(13, "src/main/resources/images/gandalf_right.png", "gandalf");
        createCell(14, "src/main/resources/images/sam_left.png", "sam");

        // enemy cells:
        createCell(15, "src/main/resources/images/orc_left.png", "orc");
        createCell(16, "src/main/resources/images/shelob.png", "shelob");
        createCell(17, "src/main/resources/images/witch_king_left.png", "witch");
        createCell(18, "src/main/resources/images/smeagol_left.png", "smeagol");

        // eye of sauron cells:
        createCell(19, "src/main/resources/images/eye_of_sauron_00.png", "sauron");
        createCell(20, "src/main/resources/images/eye_of_sauron_01.png", "sauron");
        createCell(21, "src/main/resources/images/eye_of_sauron_10.png", "sauron");
        createCell(22, "src/main/resources/images/eye_of_sauron_11.png", "sauron");

        // web cell:
        createCell(23, "src/main/resources/images/web.png", "web");
    }

    /**
     * This class draws the cells in the cell map onto the screen.
     * <p>
     * Loops through 2d array, and displays the appropriate cell image.
     * Uses drawImage() from java.awt to do the rendering.
     *
     * @param graphic image to be rendered on screen
     * @author Preet
     */
    public void draw(Graphics graphic) {
        int x = 0;
        int y = 0;

        for (int row = 0; row < screen.numRows; row++) {
            for (int col = 0; col < screen.numColumns; col++) {
                int num = map[row][col];
                graphic.drawImage(cell[num].img, x, y, ScreenPanel.cellSize, ScreenPanel.cellSize, null);
                // iterate x coordinate by size of cell
                x += ScreenPanel.cellSize;
            }
            // current column is complete - reset x coordinate and iterate y coordinate by size of cell
            x = 0;
            y += ScreenPanel.cellSize;
        }
    }
}
