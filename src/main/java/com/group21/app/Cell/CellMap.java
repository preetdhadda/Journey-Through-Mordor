package com.group21.app.Cell;

import com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;

// this call creates a map of objects from the Cell class
public class CellMap {

    Screen screen;
    // array of cells
    public Cell cell[];

    // 2d array to map the cells
    public int map[][];

    public CellMap(Screen screen) {
        this.screen = screen;
        // increase number in [] as more cell types are added
        cell = new Cell[8];

        // map legend:
        //      0 = plain background
        //      1 = lava
        //      2 = rock
        //      3, 4, 5, 6 = volcano (split into 4 pics so it can span 4 cells)
        map = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2},
                {2, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2},
                {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 2, 0, 0, 1, 2},
                {2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 2},
                {2, 2, 2, 2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 1, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 1, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {2, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 4, 5, 2},
                {2, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 6, 7, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };

        loadCellImage();
    }

    public void loadCellImage() {
        // plain background cell
        cell[0] = new Cell();
        cell[0].img = new ImageIcon("src/main/resources/images/background.png").getImage();
        cell[0].type = "empty";

        // lava cell
        cell[1] = new Cell();
        cell[1].img = new ImageIcon("src/main/resources/images/lava.png").getImage();
        cell[1].type = "lava";

        // rock cells
        cell[2] = new Cell();
        cell[2].img = new ImageIcon("src/main/resources/images/rock1.png").getImage();
        cell[2].type = "rock";
        cell[2].collision = true;

        cell[3] = new Cell();
        cell[3].img = new ImageIcon("src/main/resources/images/rock2.png").getImage();
        cell[3].type = "rock";
        cell[3].collision = true;
        
        // volcano cells
        cell[4] = new Cell();
        cell[4].img = new ImageIcon("src/main/resources/images/volcano_00.png").getImage();
        cell[4].type = "mount doom";
        cell[5] = new Cell();
        cell[5].img = new ImageIcon("src/main/resources/images/volcano_01.png").getImage();
        cell[5].type = "mount doom";
        cell[6] = new Cell();
        cell[6].img = new ImageIcon("src/main/resources/images/volcano_10.png").getImage();
        cell[6].type = "mount doom";
        cell[7] = new Cell();
        cell[7].img = new ImageIcon("src/main/resources/images/volcano_11.png").getImage();
        cell[7].type = "mount doom";
    }

    public void draw(Graphics graphic) {
        // x and y will act as coordinates for cell on map
        int x = 0;
        int y = 0;

        // loop through every element in 2d map array, and display appropriate cell image
        for (int row = 0; row < screen.numRows; row++) {
            for (int col = 0; col < screen.numColumns; col++) {
                int num = map[row][col];
                graphic.drawImage(cell[num].img, x, y, screen.cellSize, screen.cellSize, null);
                // iterate x coordinate by size of cell
                x += screen.cellSize;
            }
            // if we have reached here, the current column is complete
            // reset x coordinate and iterate y coordinate by size of cell
            x = 0;
            y += screen.cellSize;
        }
    }
}
