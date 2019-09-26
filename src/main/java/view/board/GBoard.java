/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.board;

import javax.swing.JFrame;

/**
 *
 * @author marcelo
 */
public class GBoard extends JFrame {
    
    private GPanel panel;
    
    public GBoard() {
        super("2048");
        panel = new GPanel();
        init();
    }
    
    public final void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 250, 300, 300);
        setResizable(false);
        
        buildGUI();
        
        setVisible(true);
    }
    
    private void buildGUI() {
        add(panel);
    }
}
