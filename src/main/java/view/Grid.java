/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Victor
 */
public class Grid extends JFrame{
    
    Screen s;
    
    public Grid(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setResizable(false);
        setTitle("2048");
        
        init();
    }
    
    public void init(){
        setLocationRelativeTo(null);
        
        setLayout(new GridLayout(3, 3));
        
        s = new Screen();
        add(s);
        
        setVisible(true);     
    }

    public static void main(String[] args) {
        new Grid();
    }
    
}
