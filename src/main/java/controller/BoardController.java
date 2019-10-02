package controller;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;
import view.block.*;

/**
 *
 * @author Victor
 */
public final class BoardController {

    private Random r = new Random();
    private static BoardController instance;

    private BoardController(BlockHolder[][] holders, Container board) {
        this.createRandom(holders, board);
        this.createRandom(holders, board);
    }
    
    public static BoardController getInstance(BlockHolder[][] holders, Container board) {
        if (instance == null) {
            instance = new BoardController(holders, board);
        }
        return instance;
    }
    
    public void createRandom(BlockHolder[][] holders, Container board){
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
        holders[selectedI][selectedJ].createBlock(number, false, board);        
    }

    public boolean moveLeft(BlockHolder [][] holders, Container board) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }        
        // Shifta pra Esquerda
        shiftLeft(holders);
        // Combina
        combineLeft(holders, board);
        // Shifta novamente
        shiftLeft(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }

    public boolean moveUp(BlockHolder [][] holders, Container board) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }
        // Shifta pra Cima
        shiftUp(holders);
        // Combina
        combineUp(holders, board);
        // Shifta novamente
        shiftUp(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }

    public boolean moveDown(BlockHolder [][] holders, Container board) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }
        // Shifta pra Baixo
        shiftDown(holders);
        // Combina
        combineDown(holders, board);
        // Shifta novamente
        shiftDown(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }

    public boolean moveRight(BlockHolder [][] holders, Container board) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }
        // Shifta pra Direita
        shiftRight(holders);
        // Combina
        combineRight(holders, board);
        // Shifta novamente
        shiftRight(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }


    private boolean hasMoved(ColoredBlock [][] aux, BlockHolder [][] holders) {
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                if (aux[i][j] != holders[i][j].getBlock())
                    return true;
            }
        }
        return false;
    }
    
    private void shiftLeft(BlockHolder [][] holders){              
        for(int i=0; i<4; i++){
            int aux = -1;         
            for(int j=0; j<4; j++){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = j;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[i][aux].setBlock(holders[i][j].removeBlock());                  
                    aux++;
                }   
            }
        }
    }

    private void combineLeft(BlockHolder [][] holders, Container board){
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){                
                if(holders[i][j].hasBlock() && holders[i][j+1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j+1].getBlock().getNumber()){
                    int aux = holders[i][j].removeBlock(board).getNumber() + holders[i][j+1].removeBlock(board).getNumber();
                    holders[i][j].createBlock(aux, true, board);                    
                }
            }
        }
    }
    private void shiftRight(BlockHolder [][] holders){              
        for(int i=0; i<4; i++){
            int aux = -1;         
            for(int j=3; j>=0; j--){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = j;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[i][aux].setBlock(holders[i][j].removeBlock());                  
                    aux--;
                }   
            }
        }
    }
    private void combineRight(BlockHolder [][] holders, Container board){
        for(int i=0; i<4; i++){
            for(int j=3; j>0; j--){                
                if(holders[i][j].hasBlock() && holders[i][j-1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j-1].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(board).getNumber() + holders[i][j-1].removeBlock(board).getNumber();
                    holders[i][j].createBlock(aux, true, board);                    
                }
            }
        }
    }
    
    private void shiftUp(BlockHolder [][] holders){              
        for(int j=0; j<4; j++){
            int aux = -1;         
            for(int i=0; i<4; i++){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = i;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[aux][j].setBlock(holders[i][j].removeBlock());                  
                    aux++;
                }   
            }
        }
    }
    private void combineUp(BlockHolder [][] holders, Container board){
        for(int j=0; j<4; j++){
            for(int i=0; i<3; i++){                
                if(holders[i][j].hasBlock() && holders[i+1][j].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i+1][j].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(board).getNumber() + holders[i+1][j].removeBlock(board).getNumber();
                    holders[i][j].createBlock(aux, true, board);                    
                }
            }
        }
    }
    
    private void shiftDown(BlockHolder [][] holders){              
        for(int j=0; j<4; j++){
            int aux = -1;         
            for(int i=3; i>=0; i--){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = i;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[aux][j].setBlock(holders[i][j].removeBlock());                  
                    aux--;
                }   
            }
        }
    }
    private void combineDown(BlockHolder [][] holders, Container board){
        for(int j=0; j<4; j++){
            for(int i=3; i>0; i--){                
                if(holders[i][j].hasBlock() && holders[i-1][j].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i-1][j].getBlock().getNumber()){                    
                    int aux = holders[i][j].removeBlock(board).getNumber() + holders[i-1][j].removeBlock(board).getNumber();
                    holders[i][j].createBlock(aux, true, board);                    
                }
            }
        }
    }
}
