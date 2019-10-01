package view.block;

import java.awt.Container;

/**
 *
 * @author marcelo
 */
public class BlockHolder extends ExtendableBlock {

    private ColoredBlock block;

    public BlockHolder (int x, int y) {
        super(x, y);
    }
    
    public ColoredBlock createBlock(int number, Container panel) {
        block = new ColoredBlock(number, this.getX(), this.getY());
        panel.add(block);
        return block;
    }
    
    public void setBlock(ColoredBlock block) {
        this.block = block;
        this.block.setLocation(this.getX(), this.getY());
    }
    
    public ColoredBlock getBlock() {
        return block;
    }
    
    public ColoredBlock removeBlock() {       
        ColoredBlock b = block;
        block = null;
        return b;
    }
    public ColoredBlock removeBlock(Container panel) {
        ColoredBlock b = block;
        panel.remove(b);
        panel.revalidate();
        panel.repaint();
        block = null;
        return b;
    }
    
    public boolean hasBlock(){
        return block != null;
    }
}
