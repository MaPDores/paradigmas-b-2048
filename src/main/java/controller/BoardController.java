package controller;

import view.block.*;

public class BoardController {
    BlockHolder[][] holders = new BlockHolder[4][4];
    public int initialX = 8;
    public int initialY = 8;
    public int distanceX = 81;
    public int distanceY = 81;

    public void BoardController() {
        for(int y = initialX, i = 0; i < 4; y += distanceX, i++) {
            for(int x = initialY, j = 0; j < 4; x += distanceY, j++) {
                holders[i][j] = new BlockHolder(x, y);
            }    
        }
    }
}
