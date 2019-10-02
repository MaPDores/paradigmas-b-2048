package controller;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;
import view.block.*;

/**
 *
 * @author Victor
 */
public class BoardController {
    private Random r = new Random();

    public void BoardController() {
        
    }
    
    public void createRandom(BlockHolder[][] holders, Container panel){
        ArrayList<Integer> freeI = new ArrayList();
        ArrayList<Integer> freeJ = new ArrayList();
        int number;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(holders[i][j].getBlock() == null){
                    freeI.add(i);
                    freeJ.add(j);
                }
            }           
        }
        int choosedPosition = r.nextInt(freeI.size());
        int choosedNumber = r.nextInt(10);
        if(choosedNumber < 2){                               //4 ou 2
                number = 4;
            }
            else{
                number = 2;
            }
        int selectedI = freeI.get(choosedPosition);         //coloca o valor sorteado na posicao sorteada
        int selectedJ = freeJ.get(choosedPosition);
        System.out.format("%d %d %d",selectedI, selectedJ, number);
        holders[selectedI][selectedJ].createBlock(number, false, panel);        
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
    public void combineLeft(BlockHolder [][] holders, Container panel){
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){                
                if(holders[i][j].hasBlock() && holders[i][j+1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j+1].getBlock().getNumber()){
                    int aux = holders[i][j].removeBlock(panel).getNumber() + holders[i][j+1].removeBlock(panel).getNumber();
                    holders[i][j].createBlock(aux, true, panel);                    
                }
            }
        }
    }
    public void shiftRight(BlockHolder [][] holders){              
        for(int i=0; i<4; i++){
            int aux = -1;         
            for(int j=3; j>=0; j--){
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
    
    public void combineRight(BlockHolder [][] holders, Container panel){
        for(int i=0; i<4; i++){
            for(int j=3; j>0; j--){                
                if(holders[i][j].hasBlock() && holders[i][j-1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j-1].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(panel).getNumber() + holders[i][j-1].removeBlock(panel).getNumber();
                    holders[i][j].createBlock(aux, true, panel);                    
                }
            }
        }
    }
    
    public void shiftUp(BlockHolder [][] holders){              
        for(int j=0; j<4; j++){
            int aux = -1;         
            for(int i=0; i<4; i++){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = i;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[aux][j].setBlock(holders[i][j].removeBlock());                  
                    aux = i;
                }   
            }
        }
    }
    public void combineUp(BlockHolder [][] holders, Container panel){
        for(int j=0; j<4; j++){
            for(int i=0; i<3; i++){                
                if(holders[i][j].hasBlock() && holders[i+1][j].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i+1][j].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(panel).getNumber() + holders[i+1][j].removeBlock(panel).getNumber();
                    holders[i][j].createBlock(aux, true, panel);                    
                }
            }
        }
    }
    
    public void shiftDown(BlockHolder [][] holders){              
        for(int j=0; j<4; j++){
            int aux = -1;         
            for(int i=3; i>=0; i--){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = i;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[aux][j].setBlock(holders[i][j].removeBlock());                  
                    aux = i;
                }   
            }
        }
    }
    
    public void combineDown(BlockHolder [][] holders, Container panel){
        for(int j=0; j<4; j++){
            for(int i=3; i>0; i--){                
                if(holders[i][j].hasBlock() && holders[i-1][j].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i-1][j].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(panel).getNumber() + holders[i-1][j].removeBlock(panel).getNumber();
                    holders[i][j].createBlock(aux, true, panel);                    
                }
            }
        }
    }
}
