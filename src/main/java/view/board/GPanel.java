
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.board;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author marcelo
 */
public class GPanel extends JPanel {
   
    public GPanel() {
        super();
        init();
        
        
    }
    
    private void init() {
        this.setVisible(true);
        this.setBackground(Color.BLACK);
    }
}
