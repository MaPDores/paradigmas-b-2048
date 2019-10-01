/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicasimples;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 *
 * @author Victor
 */
public class LogicaSimples {

    int [][] board;
    int COLNUM = 4;
    int ROWNUM = 4;    
    int globalPointer = 0;
    int number = 0;
    int aux = 0;
    private Random r = new Random();
    
    
    
    public static void main(String[] args) {
        LogicaSimples jogo = new LogicaSimples();  
        jogo.addTesteRow();
        //jogo.addTesteCol();
        //jogo.addRandom();
        //jogo.addRandom();
        jogo.printBoard();
        
        while(true){
            Scanner s = new Scanner(System.in);
            char ch = s.next().charAt(0);
            switch (ch) {
            case 'w':
                jogo.moveUp();
                break;
            case 'a':
                jogo.moveLeft();
                break;
            case 's':
                jogo.moveDown();
                break;
            case 'd':
                jogo.moveRight();
                break;
            }
            jogo.addRandom();
            jogo.printBoard();
        }       
    }
    
    public LogicaSimples(){
        board = new int[ROWNUM][COLNUM];
    }
    
    //so um teste
    public void addTesteRow(){
        board[0][0] = 0;
        board[1][0] = 2;
        board[2][0] = 0;
        board[3][0] = 2; 
    }
    
    public void addTesteCol(){
        board[0][0] = 2;
        board[0][1] = 4;
        board[0][2] = 4;
        board[0][3] = 4; 
    }
    
    //cria 2 arrays com as pos
    public void addRandom(){
        ArrayList<Integer> freeX = new ArrayList();             //cria 2 listas com as posicoes livres
        ArrayList<Integer> freeY = new ArrayList();
        for(int i=0; i<ROWNUM; i++){
            for(int j=0; j<COLNUM; j++){                        //procura quais posicoes estao livres e adiciona na lista
                if(board[i][j] == 0){
                   int [] freeSpace = {i, j};
                   freeX.add(i);
                   freeY.add(j);                  
                }
            }
        }        
        try{
            int choosedPosition = r.nextInt(freeX.size());
            int choosedNumber = r.nextInt(10);
            if(choosedNumber < 2){                              //4 ou 2
                number = 4;
            }
            else{
                number = 2;
            }
            int selectedX = freeX.get(choosedPosition);         //coloca o valor sorteado na posicao sorteada
            int selectedY = freeY.get(choosedPosition);
            board[selectedX][selectedY] = number;
        }catch(Exception e){
            System.out.println("algo de errado nao esta certo");
        }
    }
    public void printBoard() {
        String output = "";
        for (int i = 0; i < ROWNUM; i++) {
            String row = "";
            for (int j = 0; j < COLNUM; j++) {
                row += board[i][j] + ",";
            }
            row += "\n";
            output += row;
        }
        System.out.println(output);
    }
    
    //uaauhsuahsuahsuahsuahsuahsuahsuaushaushauhsuahsuahsuahushaushaushuahs
    public void moveUp() {
        for (int col = 0; col < COLNUM; col++) {
            globalPointer = 0;
            for (int row = 0; row < ROWNUM; row++) {
                
                if (board[row][col] != 0) {
                    
                     if (globalPointer <= row) {
                        shiftRowTiles(row, col, false);
                    }
                }
            }
        }
    }
    
    public void moveDown() {
        for (int col = 0; col < COLNUM; col++) {
            globalPointer = ROWNUM - 1;
            for (int row = ROWNUM -1; row >= 0; row--) {
                if (board[row][col] != 0) {
                    if (globalPointer >= row) {
                        shiftRowTiles(row, col, true);
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for (int row = 0; row < ROWNUM; row++) {
            globalPointer = 0;
            for (int col = 0; col < COLNUM; col++) {
                if (board[row][col] != 0) {
                    if (globalPointer <= col) {
                        shiftColTiles(row, col, false);
                    } 
                }
            }
        }
    }

    public void moveRight() {
        for (int row = 0; row < ROWNUM; row++) {
            globalPointer = COLNUM - 1;
            for (int col = COLNUM - 1; col >= 0; col--) {
                if (board[row][col] != 0) {
                    if (globalPointer >= col) {
                        shiftColTiles(row, col, true);
                    } 
                }
            }
        }
    }

    private void shiftRowTiles(int currentRow, int currentCol, boolean reverse) {
        // caso os valores sejam os mesmos, junta
           if (board[globalPointer][currentCol] == 0 || board[globalPointer][currentCol] == board[currentRow][currentCol]) {
               if (currentRow > globalPointer || (reverse && (globalPointer > currentRow))) {
                   if(board[globalPointer][currentCol] == 0){
                       aux = 1;
                   }
                   board[globalPointer][currentCol] += board[currentRow][currentCol];
                   board[currentRow][currentCol] = 0;
                   if(aux != 1){
                       if(reverse){
                            globalPointer--;
                       }else{
                            globalPointer++;
                       }                       
                   }
                   aux = 0;
               }
           } else {
               if (reverse) {
                   globalPointer--;
               } else {
                   globalPointer++;
               }
               // shift para juntar apos a soma dos valores
               shiftRowTiles(currentRow, currentCol, reverse);
           }
       }

    private void shiftColTiles(int currentRow, int currentCol, boolean reverse) {
           if (board[currentRow][globalPointer] == 0 || board[currentRow][globalPointer] == board[currentRow][currentCol]) {
               if (currentCol > globalPointer || (reverse && (globalPointer > currentCol))) {
                   
                   if(board[currentRow][globalPointer] == 0){
                       aux = 1;
                   }
                   board[currentRow][globalPointer] += board[currentRow][currentCol];
                   board[currentRow][currentCol] = 0;   
                   if(aux != 1){
                       if(reverse){
                            globalPointer--;
                       }else{
                            globalPointer++;
                       }                       
                   }
                   aux = 0;
               }
           } else {
               if (reverse) {
                   globalPointer--;
               } else {
                   globalPointer++;
               }
               shiftColTiles(currentRow, currentCol, reverse);
           }
        }
    
    class MyKeyListener extends KeyAdapter{
        
        public void KeyPresser(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
                moveDown();
            } else if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
                moveLeft();
            } else if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
                moveRight();
            }
        }
    }
}

