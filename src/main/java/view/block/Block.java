package view.block;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author marcelo
 */
class Block extends JLabel{
    public int number;
    
    public Block (int number, int x, int y) {
        super(new ImageIcon("/assets/2.png"));
        this.number = number;
        this.setBounds(x, y, WIDTH, HEIGHT);
    }
}
