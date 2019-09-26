package controller;

import view.block.*;

public class BoardController {
    BlockHolder[][] holders = new BlockHolder[4][4];
    
    public void BoardController() {
        for(int k = 8, i = 0; i < 4; k += 65, i++) {
            for(int l = 8, j = 0; j < 4; l += 65, j++) {
                holders[i][j] = new BlockHolder(l, k);
            }    
        }
    }
}
