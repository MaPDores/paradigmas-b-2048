package view.block;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 *
 * @author marcelo
 */
public class BlockHolder extends JLabel{
    private Block block;
    
    public BlockHolder (int x, int y) {
        super();
        this.setBounds(x, y, 25, 25);
    }
    
    public void createBlock(int number) {
        this.block = new Block(number, this.getX(), this.getY());
    }
}
