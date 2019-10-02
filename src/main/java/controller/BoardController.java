package controller;

import java.awt.Container;
import view.block.BlockHolder;

/**
 *
 * @author Victor
 */
public class BoardController {
    public void BoardController() {
        
    }
    
    public void shiftLeft(BlockHolder [][] holders){              
        for(int i=0; i<4; i++){
            int aux = -1;         
            for(int j=0; j<4; j++){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = j;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[i][aux].setBlock(holders[i][j].removeBlock());                   
                    aux = j;
                }
            }
        }
    }
    public void combineLeft(BlockHolder [][] holders, Container board){
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){                
                if(holders[i][j].hasBlock() && holders[i][j+1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j+1].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(board).getNumber() + holders[i][j+1].removeBlock(board).getNumber();
                    holders[i][j].createBlock(aux, true, board);                    
                }
            }
        }
    }
    
}
