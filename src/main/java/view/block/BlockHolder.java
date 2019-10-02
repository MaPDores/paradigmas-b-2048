package view.block;

import java.awt.Container;
import view.animation.BlockAnimator;

/**
 *
 * @author marcelo
 */
public class BlockHolder extends ExtendableBlock {

    private ColoredBlock block;
    //TODO: colocar objeto board na classe
    private BlockAnimator animator = new BlockAnimator();

    public BlockHolder (int x, int y) {
        super(x, y);
    }
    
    public ColoredBlock createBlock(int number, boolean isCombined, Container board) {
        block = new ColoredBlock(number, this.getX(), this.getY());
        board.add(block);
        if (isCombined)
            animator.start(block, board);
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
    public ColoredBlock removeBlock(Container board) {
        ColoredBlock b = block;
        board.remove(b);
        board.revalidate();
        board.repaint();
        block = null;
        return b;
    }
    
    public boolean hasBlock(){
        return block != null;
    }
}
