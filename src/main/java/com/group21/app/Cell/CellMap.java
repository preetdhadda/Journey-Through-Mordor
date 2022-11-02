package com.group21.app.Cell;

import javax.swing.*;

import com.group21.app.Screen.ScreenPanel;

import java.awt.*;

// this call creates a map of objects from the Cell class
public class CellMap {

    ScreenPanel screen;
    // array of cells
    public Cell cell[];

    // 2d array to map the cells
    public int map[][];

    public CellMap(ScreenPanel screen) {
        this.screen = screen;
        // increase number in [] as more cell types are added
        cell = new Cell[25];

        // map legend:
        //      0 = plain background
        //      1 = lava
        //      2 = rock
        //      3 = rock + lava
        //      4, 5, 6, 7 = volcano (split into 4 pics so it can span 4 cells)
        //      8 = bow
        //      9 = bread
        //      10 = dagger
        //      11 = spear
        //      12 = water
        //      13 = gandalf
        //      14 = sam
        //      15 = orc
        //      16 = shelob
        //      18 = witch king
        //      19 = gollum
        //      20, 21, 22, 23 = eye of sauron
        //      24 = spider web
        map = new int[][] {
            {2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2},
            {2 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 0 , 0 , 24 , 0 , 2 , 0 , 0 , 0 , 2 , 2 , 2 , 2 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 2},
            {2 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2},
            {2 , 0 , 2 , 0 , 0 , 0 , 0 , 24 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 1 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , 2 , 2 , 2},
            {2 , 0 , 2 , 0 , 24 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 1 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2},
            {2 , 0 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 1 , 1 , 1 , 1 , 0 , 0 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2},
            {2 , 0 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 24 , 0 , 0 , 20 , 21 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 1 , 0 , 2 , 2 , 0 , 0 , 1 , 2},
            {2 , 0 , 0 , 0 , 0 , 0 , 2 , 0 , 0 , 0 , 0 , 0 , 22 , 23 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 , 2},
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

    public void loadCellImage() {
        // plain background cell
        cell[0] = new Cell();
        cell[0].img = new ImageIcon("src/main/resources/images/background.png").getImage();
        cell[0].type = "empty";

        // lava cell (punishment cell)
        cell[1] = new Cell();
        cell[1].img = new ImageIcon("src/main/resources/images/lava.png").getImage();
        cell[1].type = "lava";

        // rock cells (obstacle)
        cell[2] = new Cell();
        cell[2].img = new ImageIcon("src/main/resources/images/rock1.png").getImage();
        cell[2].type = "rock";
        cell[2].collision = true;
        cell[3] = new Cell();
        cell[3].img = new ImageIcon("src/main/resources/images/rock2.png").getImage();
        cell[3].type = "rock";
        cell[3].collision = true;
        
        // volcano cells (winning cells)
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

        // bow (reward)
        cell[8] = new Cell();
        cell[8].img = new ImageIcon("src/main/resources/images/bow.png").getImage();
        cell[8].type = "bow";

        // bread (reward)
        cell[9] = new Cell();
        cell[9].img = new ImageIcon("src/main/resources/images/bread.png").getImage();
        cell[9].type = "bread";

        // dagger (reward)
        cell[10] = new Cell();
        cell[10].img = new ImageIcon("src/main/resources/images/dagger.png").getImage();
        cell[10].type = "dagger";

        // spear (reward)
        cell[11] = new Cell();
        cell[11].img = new ImageIcon("src/main/resources/images/spear.png").getImage();
        cell[11].type = "spear";

        // water (reward)
        cell[12] = new Cell();
        cell[12].img = new ImageIcon("src/main/resources/images/water.png").getImage();
        cell[12].type = "water";

        // gandalf (bonus)
        cell[13] = new Cell();
        cell[13].img = new ImageIcon("src/main/resources/images/gandalf_right.png").getImage();
        cell[13].type = "gandalf";

        // sam (bonus)
        cell[14] = new Cell();
        cell[14].img = new ImageIcon("src/main/resources/images/sam_left.png").getImage();
        cell[14].type = "sam";

        // orc (enemy)
        cell[15] = new Cell();
        cell[15].img = new ImageIcon("src/main/resources/images/orc_left.png").getImage();
        cell[15].type = "orc";

        // shelob (enemy)
        cell[16] = new Cell();
        cell[16].img = new ImageIcon("src/main/resources/images/shelob.png").getImage();
        cell[16].type = "shelob";

        // witch king (enemy)
        cell[18] = new Cell();
        cell[18].img = new ImageIcon("src/main/resources/images/witch_king_left.png").getImage();
        cell[18].type = "witch";

        // smeagol (enemy)
        cell[19] = new Cell();
        cell[19].img = new ImageIcon("src/main/resources/images/smeagol_left.png").getImage();
        cell[19].type = "smeagol";

        // eye of sauron cells (punishment cells)
        cell[20] = new Cell();
        cell[20].img = new ImageIcon("src/main/resources/images/eye_of_sauron_00.png").getImage();
        cell[20].type = "sauron";
        cell[21] = new Cell();
        cell[21].img = new ImageIcon("src/main/resources/images/eye_of_sauron_01.png").getImage();
        cell[21].type = "sauron";
        cell[22] = new Cell();
        cell[22].img = new ImageIcon("src/main/resources/images/eye_of_sauron_10.png").getImage();
        cell[22].type = "sauron";
        cell[23] = new Cell();
        cell[23].img = new ImageIcon("src/main/resources/images/eye_of_sauron_11.png").getImage();
        cell[23].type = "sauron";

        // spider web (punishment cells)
        cell[24] = new Cell();
        cell[24].img = new ImageIcon("src/main/resources/images/web.png").getImage();
        cell[24].type = "web";
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
